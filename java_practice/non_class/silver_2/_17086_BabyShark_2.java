package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17086_BabyShark_2 {
    static int[][] direction = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n == 1;
                if(n == 1) q.add(new int[]{i, j, 0});
            }
        }
        int cnt = bfs(map, h, w);
        System.out.println(cnt);
    }

    public static int bfs(boolean[][] map, int h, int w) {
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int curH = pos[0], curW = pos[1];
            cnt = pos[2];
            for(int[] dir: direction) {
                int newH = curH + dir[0];
                int newW = curW + dir[1];
                if(newH<0 || newW<0 || newH>=h || newW>=w) continue;
                if(map[newH][newW]) continue;
                map[newH][newW] = true;
                q.add(new int[]{newH, newW, cnt+1});
            }
        }
        return cnt;
    }
}
