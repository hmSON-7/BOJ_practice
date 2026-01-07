package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4779_CantorSet {
    static StringBuilder sb = new StringBuilder();
    static String[] dp = new String[13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = "-";
        String str;
        while((str = br.readLine()) != null && !str.isEmpty()) {
            int n = Integer.parseInt(str);
            sb.append(cantor(n)).append("\n");
        }
        System.out.println(sb);
    }

    static String cantor(int n) {
        if (n == 0) return "-";
        if (dp[n] != null) return dp[n];
        String prev = cantor(n - 1);

        StringBuilder spaceSb = new StringBuilder();
        int len = prev.length();
        for (int i = 0; i < len; i++) {
            spaceSb.append(" ");
        }
        String spaces = spaceSb.toString();

        dp[n] = prev + spaces + prev;
        return dp[n];
    }
}
