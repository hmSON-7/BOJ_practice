package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9252_LCS_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i=1; i<=s1.length; i++) {
            for(int j=1; j<=s2.length; j++) {
                if(s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[s1.length][s2.length]);
        StringBuilder sb = new StringBuilder();
        int curI = s1.length, curJ = s2.length;
        while(curI > 0 && curJ > 0) {
            if(s1[curI-1] == s2[curJ-1]) {
                sb.append(s1[curI-1]);
                curI--;
                curJ--;
            } else {
                if(dp[curI-1][curJ] >= dp[curI][curJ-1]) curI--;
                else curJ--;
            }
        }
        System.out.println(sb.reverse());
    }
}
