package Rank4.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1932_IntegerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        dp[0][0] = Integer.parseInt(br.readLine());
        for(int i=1; i<n; i++) {
            String[] line = br.readLine().trim().split(" ");
            for(int j=0; j<line.length; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + Integer.parseInt(line[j]);
                else if(j == i) dp[i][j] = dp[i-1][j-1] + Integer.parseInt(line[j]);
                else {
                    int n1 = dp[i-1][j-1], n2 = dp[i-1][j];
                    int current = Integer.parseInt(line[j]);
                    dp[i][j] = Math.max(n1 + current, n2 + current);
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}
