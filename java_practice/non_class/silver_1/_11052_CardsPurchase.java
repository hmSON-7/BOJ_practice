package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052_CardsPurchase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++) {
            int max = dp[i];
            for(int j=1; j<=i-1; j++) {
                max = Math.max(max, dp[j] + dp[i-j]);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }
}
