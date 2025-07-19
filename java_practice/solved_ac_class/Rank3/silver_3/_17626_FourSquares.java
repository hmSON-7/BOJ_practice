package Rank3.silver_3;

import java.util.Scanner;

public class _17626_FourSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        for(int i=2; i<=n; i++) {
            int min = 5;
            for(int j=1; j<=(int)Math.sqrt(i); j++) {
                min = Math.min(min, dp[i-(j*j)]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[n]);
    }
}
