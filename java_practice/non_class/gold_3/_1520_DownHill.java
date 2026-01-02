package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1520_DownHill {
    public static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int h, w;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w]; dp = new int[h][w];
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<h; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int y, int x) {
        if(y == h-1 && x == w-1) return 1;
        if(dp[y][x] != -1) return dp[y][x];
        dp[y][x] = 0;
        for(int[] d : direction) {
            int newY = y + d[0];
            int newX = x + d[1];
            if(newY < 0 || newY >= h || newX < 0 || newX >= w || map[newY][newX] >= map[y][x]) continue;
            dp[y][x] += dfs(newY, newX);
        }
        return dp[y][x];
    }
}
