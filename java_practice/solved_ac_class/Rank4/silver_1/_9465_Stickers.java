package Rank4.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465_Stickers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[100001][2];
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            dp[0][0] = 0; dp[0][1] = 0;
            for(int i=0; i<=1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++) {
                    dp[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=2; i<=n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + dp[i][0]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + dp[i][1]);
            }
            sb.append(Math.max(dp[n][0], dp[n][1])).append('\n');
        }
        System.out.println(sb);
    }
}
