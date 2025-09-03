package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458 {

	// 정점과 간선 수
	static int v, e;
	// 단방향 인접행렬
	static boolean[][] list;
	
	public static void main(String[] args) throws Exception {
		init();
		floydWarshall();
		
		// 각 정점별로 다른 정점들과 비교 가능한 위치인지 확인
		int cnt = 0;
		for(int i=0; i<v; i++) {
			cnt += count(i) ? 1 : 0;
		}
		System.out.println(cnt);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new boolean[v][v];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			list[v1][v2] = true;
		}
	}
	
	static void floydWarshall() {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				// 세 항목은 모두 달라야 함. 두 개가 같으므로 무시
				// 경유지로 이동할 방법이 없는 경우도 무시
				if(i == j || !list[j][i]) continue;
				for(int k=0; k<v; k++) {
					// 같은 값이 존재하면 무시
					if(k==i || k==j) continue;
					// list[j][i]가 true임을 전제로 하므로 list[i][k] 값에 따라 발생하는 결과를 list[j][k]에 입력
					// 단, 기존의 1이 0으로 덮어씌워지는 것을 방지하기 위해 이미 1인 경우 유지
					list[j][k] = list[j][k] || list[i][k];
				}
			}
		}
	}
	
	static boolean count(int x) {
		int cnt = 0;
		// 결국 자신이 다른 정점과 비교하여 앞인지, 뒤인지만 알면 됨.
		// 가로열이 뒤, 세로열이 앞임.
		// v-1개 접근, 즉 다른 모든 정점과의 관계를 가질 째 true 반환
		for(int i=0; i<v; i++) {
			if(list[i][x]) cnt++;
			if(list[x][i]) cnt++;
		}
		
		return cnt == v-1;
	}
	
}
