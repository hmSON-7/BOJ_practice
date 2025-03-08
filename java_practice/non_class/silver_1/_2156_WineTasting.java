package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156_WineTasting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        for(int i=0; i<n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n+1];
        dp[1] = wines[0];
        if(n > 1) dp[2] = wines[0] + wines[1];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wines[i-2]) + wines[i-1]);
        }
        System.out.println(dp[n]);
    }
}
