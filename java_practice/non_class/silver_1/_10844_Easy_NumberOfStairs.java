package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_Easy_NumberOfStairs {
    static final long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        long[][] dp = new long[len+1][10];
        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i<=len; i++) {
            for(int j=0; j<10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1] % mod;
                else if(j == 9) dp[i][j] = dp[i - 1][8] % mod;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++) {
            sum += dp[len][i];
        }
        System.out.println(sum % mod);
    }
}
