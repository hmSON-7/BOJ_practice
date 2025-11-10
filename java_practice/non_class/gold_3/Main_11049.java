package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n][n];
		for(int i=1; i<n; i++) {
			for(int j=i; j<n; j++) {
				int min = Integer.MAX_VALUE;
				for(int k=0; k<i; k++) {
					int res = dp[j-i][j-i+k] + dp[j-i+1+k][j] + (arr[j-i][0] * arr[j][1] * arr[j-i+k][1]);
					min = Math.min(min, res);
				}
				
				dp[j-i][j] = min;
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

}
