package silver_3;

import java.util.*;

public class _9095Plus123 {
    static int[] dp = new int[12];

    public static void main(String[] args) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int res = calc(n);
            System.out.println(res);
        }
    }

    static int calc(int n) {
        if(dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = calc(n-1) + calc(n-2) + calc(n-3);
            return dp[n];
        }
    }
}