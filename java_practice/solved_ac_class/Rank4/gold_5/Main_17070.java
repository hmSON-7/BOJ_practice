package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
	
	// 맵 크기
	static int n;
	// 현재 맵 정보를 비트마스킹으로 저장. 벽이 1
	static int[] map;
	// 각 위치마다 도착 가능한 경우의 수를 가로, 대각, 세로 순서로 저장
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		init();
		
		// DP를 이용해 각 경로까지 이동할 수 있는 경우의 수 계산
		// 가로 파이프 : 가로 + 대각
		// 대각 파이프 : 가로 + 대각 + 세로
		// 세로 파이프 : 대각 + 세로
		// 단, 현 위치가 벽인 경우 무시
		// 또한 대각 파이프는 위 또는 왼쪽에 벽이 있으면 설치할 수 없음
		for(int i=1; i<=n; i++) {
			for(int j=2; j<n; j++) {
				if((map[i] & 1<<j) != 0) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				if((map[i] & 1<<(j-1)) == 0 && (map[i-1] & 1<<j) == 0)
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
			}
		}
		
		// 도착점의 모든 경우의 수를 합산하여 출력
		int sum = dp[n][n-1][0] + dp[n][n-1][1] + dp[n][n-1][2];
		
		System.out.println(sum);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1];
		dp = new int[n+1][n][3];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int x = Integer.parseInt(st.nextToken());
				// 벽을 1로 표현
				if(x == 1) {
					map[i] |= 1<<j;
				}
			}
		}
		
		// 초기 파이프 위치
		dp[1][0][0] = dp[1][1][0] = 1;
	}

}
