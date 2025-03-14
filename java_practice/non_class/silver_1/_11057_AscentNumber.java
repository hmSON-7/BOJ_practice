package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11057_AscentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for(int i=2; i<=n; i++) {
            for(int j=1; j<10; j++) {
                dp[j] = (dp[j] + dp[j-1]) % 10007;
            }
        }
        int sum = 0;
        for(int x : dp) {
            sum += x;
        }
        System.out.println(sum%10007);
    }
}
