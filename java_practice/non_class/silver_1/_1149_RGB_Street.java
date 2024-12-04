package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1149_RGB_Street {
    static int r = 0, g = 1, b = 2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        String[] line = br.readLine().trim().split(" ");
        dp[0][r] = Integer.parseInt(line[r]);
        dp[0][g] = Integer.parseInt(line[g]);
        dp[0][b] = Integer.parseInt(line[b]);
        for(int i=1; i<n; i++) {
            line = br.readLine().trim().split(" ");
            dp[i][r] = Math.min(dp[i-1][g], dp[i-1][b]) + Integer.parseInt(line[r]);
            dp[i][g] = Math.min(dp[i-1][r], dp[i-1][b]) + Integer.parseInt(line[g]);
            dp[i][b] = Math.min(dp[i-1][r], dp[i-1][g]) + Integer.parseInt(line[b]);
        }

        int max = Math.min(dp[n-1][r], Math.min(dp[n-1][g], dp[n-1][b]));
        System.out.println(max);
    }
}
