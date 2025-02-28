package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25418_IntegerAtoK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] dp = new int[end+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        for (int i=start+1; i<=end; i++) {
            dp[i] = dp[i-1] + 1;
            if (i%2 == 0 && dp[i/2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }
        System.out.println(dp[end]);
    }
}
