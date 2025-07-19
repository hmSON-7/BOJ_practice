package Rank3.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_PadovanSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] cases = new int[t];
        int max = 0;

        for(int i=0; i<t; i++) {
            cases[i] = Integer.parseInt(br.readLine());
            max = Math.max(cases[i], max);
        }

        long[] tri = new long[]{1, 0, 1, 0, 1, 0};
        long[] dp = new long[max];
        dp[0] = 1;
        for(int i=1; i<max; i++) {
            int idx = (i-1)%6;
            dp[i] = tri[idx];
            tri[idx] = 0; tri[i%6] += dp[i]; tri[(i+4)%6] += dp[i];
        }

        for(int i=0; i<t; i++) {
            System.out.println(dp[cases[i] - 1]);
        }
    }
}
