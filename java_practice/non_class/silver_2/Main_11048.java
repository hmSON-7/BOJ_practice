package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] dp = new int[r+1][c+1];
		
		for(int i=1; i<=r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=c; j++) {
				int x = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j])) + x;
			}
		}
		
		System.out.println(dp[r][c]);
	}
	
}
