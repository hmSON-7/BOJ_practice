package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31575_CityAndBitcoin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        boolean[][] dp = new boolean[h][w];
        dp[0][0] = true;
        for(int i=1; i<h; i++) {
            dp[i][0] = map[i][0] && dp[i-1][0];
        }
        for(int i=1; i<w; i++) {
            dp[0][i] = map[0][i] && dp[0][i-1];
        }
        for(int i=1; i<h; i++) {
            for(int j=1; j<w; j++) {
                dp[i][j] = map[i][j] && (dp[i-1][j] || dp[i][j-1]);
            }
        }
        System.out.println(dp[h-1][w-1] ? "Yes" : "No");
    }
}
