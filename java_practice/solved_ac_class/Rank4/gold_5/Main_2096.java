package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		int[][] minDP = new int[n+1][3];
		int[][] maxDP = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			minDP[i][0] = Math.min(minDP[i-1][0], minDP[i-1][1]) + arr[0];
			minDP[i][1] = Math.min(minDP[i-1][0], Math.min(minDP[i-1][1], minDP[i-1][2])) + arr[1];
			minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + arr[2];
			
			maxDP[i][0] = Math.max(maxDP[i-1][0], maxDP[i-1][1]) + arr[0];
			maxDP[i][1] = Math.max(maxDP[i-1][0], Math.max(maxDP[i-1][1], maxDP[i-1][2])) + arr[1];
			maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + arr[2];
		}
		
		int max = Math.max(maxDP[n][0], Math.max(maxDP[n][1], maxDP[n][2]));
		int min = Math.min(minDP[n][0], Math.min(minDP[n][1], minDP[n][2]));
		
		System.out.println(max + " " + min);
	}

}
