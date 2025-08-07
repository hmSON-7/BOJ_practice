package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {
	
	// SWEA_2001 : 파리퇴치
	// 배열상의 (0, 0)부터 현재 위치까지의 구간합을 배열에 저장하고, 연산을 통해 특정 구역에 대한 구간합을 구하는 방식으로 작성
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	// 각각 배열의 크기와, 파리 퇴치 지역의 범위
	static int n, range;
	// 해당 배열에는 각 위치별 파리의 수가 아닌, 구간합이 들어감
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			solve(i);
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		memo = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int x = Integer.parseInt(st.nextToken());
				memo[i][j] = x + memo[i][j-1] + memo[i-1][j] - memo[i-1][j-1];
			}
		}
	}
	
	public static void solve(int idx) {
		sb.append("#").append(idx).append(" ");
		int maxCnt = 0;
		for(int i=range; i<=n; i++) {
			for(int j=range; j<=n; j++) {
				int killCnt = memo[i][j] - memo[i-range][j] - memo[i][j-range] + memo[i-range][j-range];
				if(killCnt > maxCnt) maxCnt = killCnt;
			}
		}
		sb.append(maxCnt).append("\n");
	}
}
