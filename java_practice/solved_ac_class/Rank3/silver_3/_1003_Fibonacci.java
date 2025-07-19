package Rank3.silver_3;

import java.io.*;

public class _1003_Fibonacci {
    static Integer[][] dp = new Integer[41][2];

    static Integer[] fibonacci(int n) {
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException{
        // 선언 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1; dp[0][1] = 0; dp[1][0] = 0; dp[1][1] = 1;

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else if(n == 1) {
                sb.append(0).append(" ").append(1).append("\n");
            } else {
                Integer[] res = fibonacci(n);
                sb.append(res[0]).append(" ").append(res[1]).append("\n");
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}