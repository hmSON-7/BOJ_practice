package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1030 {

	// 흰색 확장 구역과 검은색 확장 구역을 구분하여 각각 단위 길이를 가진 섹터로 구분해야 함
	// 또, 각 섹터 내에 출력하고자 하는 범위인 r1, r2, c1, c2 범위와 단 한 칸이라도 겹쳐는 섹터들만 확인하고 재귀를 들어가야 함
	// 미리 배열을 만들고자 하면 최악의 경우 8^10 = 1,073,741,824 길이의 변을 가진 정사각형 배열을 요구하게 됨.
	
	// 시간, 1*1 평면의 확장 길이, 확장된 평면에서 검은색 구역의 크기, 출력하고자 하는 위치의 사각형 좌표
	static int t, n, k, r1, r2, c1, c2;
	// 평면을 단위 길이별로 나누어 섹터를 분리하고, 그 중 검은색 구역이 어느 섹터에 해당하는 지 확인하는 용도
	static int blackEdge1, blackEdge2;
	// 출력할 부분만 저장하는 2차원 배열
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		init();
		// 분할 정복의 초기값은 좌표 (0, 0), 흰색, 평면의 변의 길이
		divide(0, 0, false, (int)Math.pow(n, t));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=r2-r1; i++) {
			for(int j=0; j<=c2-c1; j++) {
				sb.append(map[i][j] ? 1 : 0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		// 출력에 필요한 부분만 저장하기 위한 배열 크기 설정
		map = new boolean[r2-r1+1][c2-c1+1];
		
		// n과 k는 반드시 둘 다 홀수거나 짝수이므로 n-k는 반드시 짝수임.
		// 이를 이용해 검은색 구역의 시작 구역과 끝 구역을 구함
		blackEdge1 = (n-k)/2;
		blackEdge2 = n - 1 - blackEdge1;
	}
	
	// 분할 정복. 초기값은 각 평면의 시작 좌표, 구역의 색(true : 검은색), 현재 평면의 변의 길이
	static void divide(int sy, int sx, boolean black, int len) {
		// 길이가 1이 되면 더 나눌 수 없으므로 이 칸의 색을 저장
		if(len == 1) {
			map[sy - r1][sx - c1] = black;
			return;
		}
		
		// 현재 평면의 단위길이
		int unitLen = len / n;
		
		// 현재 평면을 단위 길이로 나눈 섹터들 중, 출력하고자 하는 범위에 포함된 섹터 좌표를 구함
		int sectorR1 = r1 >= sy ? (r1-sy) / unitLen : 0;
		int sectorR2 = r2 <= sy + len - 1 ? (r2-sy) / unitLen : n-1;
		int sectorC1 = c1 >= sx ? (c1-sx) / unitLen : 0;
		int sectorC2 = c2 <= sx + len - 1 ? (c2-sx) / unitLen : n-1;
		// 출력 범위 내부에 한 칸이라도 들어간 섹터에 대해서면 추가적인 분할 정복 실행
		for(int i=sectorR1; i<=sectorR2; i++) {
			for(int j=sectorC1; j<=sectorC2; j++) {
				divide(
						sy + (unitLen*i), 
						sx + (unitLen*j), 
						// 이미 검은색 구역이면 그대로 검은색으로, 흰색 구역이면 블랙 엣지 내부인지 확인
						black ? black : (i>=blackEdge1 && i<=blackEdge2) && (j>=blackEdge1 && j<=blackEdge2), 
						unitLen
				);
			}
		}
	}
	
}
