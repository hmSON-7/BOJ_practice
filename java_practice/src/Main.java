import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        long[][] dp = new long[65][11];
        Arrays.fill(dp[1], 1);
        dp[1][10] = 10;

        for(int i=2; i<=64; i++) {
            dp[i][0] = 1;
            dp[i][10] = 1;
            for(int j=1; j<=9; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][10] += dp[i][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int id = Integer.parseInt(br.readLine());
            sb.append(dp[id][10]).append("\n");
        }
        System.out.println(sb);
    }

}