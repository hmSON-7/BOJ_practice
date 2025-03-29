package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780_CountOfPapers {
    static int[] cnt = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(n, paper, 0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void cut(int n, int[][] paper, int r, int c) {
        int curr = paper[r][c];
        if(n == 1 || check(curr, n, paper, r, c)) {
            cnt[curr+1]++;
            return;
        }
        int dist = n/3;
        cut(dist, paper, r, c);
        cut(dist, paper, r+dist, c);
        cut(dist, paper, r+(2*dist), c);
        cut(dist, paper, r, c+dist);
        cut(dist, paper, r+dist, c+dist);
        cut(dist, paper, r+(2*dist), c+dist);
        cut(dist, paper, r, c+(2*dist));
        cut(dist, paper, r+dist, c+(2*dist));
        cut(dist, paper, r+(2*dist), c+(2*dist));
    }

    static boolean check(int curr, int n, int[][] paper, int r, int c) {
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(curr != paper[i][j]) return false;
            }
        }
        return true;
    }
}
