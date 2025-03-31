package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2705_PalindromicPartitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int max = 1;
        int[] dp = new int[1001];
        dp[0] = 1; dp[1] = 1;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for(int i=max; i<=n; i++) {
                dp[i] = 1;
                for(int j=i-2; j>=0; j-=2) {
                    dp[i] += dp[(i-j)/2];
                }
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
