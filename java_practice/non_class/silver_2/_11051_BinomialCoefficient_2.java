package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11051_BinomialCoefficient_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        System.out.println(bc(dp, n, k));
    }

    public static int bc(int[][] dp, int n, int k) {
        if(dp[n][k] != 0) return dp[n][k];
        if(n == k || k == 0) return dp[n][k] = 1;
        return dp[n][k] = (bc(dp, n-1, k-1) + bc(dp, n-1, k)) % 10007;
    }
}
