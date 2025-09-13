package silver_1;

import java.util.Scanner;

public class Main_1309 {
	
	static final int MOD = 9901;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][3];
		
		// 0�� ���ڸ� �츮�� ���� �ʴ� ���,
		// 1�� 2�� �� �츮�� ���ڸ� �ִ� ���
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[0][2] = 0;
		
		for(int i=1; i<=n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
		}
		
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2])% MOD);
	}

}
