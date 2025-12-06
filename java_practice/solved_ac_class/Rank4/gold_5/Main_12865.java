package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[max+1];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int w = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	for(int j=max; j>=w; j--) {
        		dp[j] = Math.max(dp[j-w] + v, dp[j]);
        	}
        }
        
        System.out.println(dp[max]);
    }
	
}
