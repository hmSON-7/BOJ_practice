package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294_Coin_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] dp = new int[total+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if(coin > total) continue;
            dp[coin] = 1;
        }
        for(int i=1; i<=total; i++) {
            int min = dp[i];
            for(int j=1; j<=i/2; j++) {
                min = Math.min(min, dp[j]+dp[i-j]);
            }
            dp[i] = min;
        }
        System.out.println(dp[total] >= 100001 ? -1 : dp[total]);
    }
}
