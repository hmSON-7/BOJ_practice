package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25682_RepaintingChessBoard_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] board = new String[r];
        for(int i=0; i<r; i++) {
            board[i] = br.readLine();
        }
        int[][] dp1 = new int[r+1][c+1], dp2 = new int[r+1][c+1];
        for(int i=1; i<=r; i++) {
            for(int j=1; j<=c; j++) {
                char ch = board[i-1].charAt(j-1);
                int mis1 = 0, mis2 = 0;
                if((i+j)%2 == 0) {
                    if(ch != 'B') mis1 = 1; else mis2 = 1;
                } else {
                    if(ch != 'W') mis1 = 1; else mis2 = 1;
                }
                dp1[i][j] = dp1[i-1][j] + dp1[i][j-1] - dp1[i-1][j-1] + mis1;
                dp2[i][j] = dp2[i-1][j] + dp2[i][j-1] - dp2[i-1][j-1] + mis2;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=n; i<=r; i++) {
            for(int j=n; j<=c; j++) {
                int cnt1 = dp1[i][j] - dp1[i-n][j] - dp1[i][j-n] + dp1[i-n][j-n];
                int cnt2 = dp2[i][j] - dp2[i-n][j] - dp2[i][j-n] + dp2[i-n][j-n];
                min = Math.min(Math.min(cnt1, cnt2), min);
            }
        }
        System.out.println(min);
    }
}
