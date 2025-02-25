package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _31564_EscapeFromHexagonalMaze {
    static int[][][] direction = {
            {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}},
            {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}},
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[h][w];
        for(int i=0; i<block; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            visited[y][x] = true;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int time = cur[2];
            if(cur[0] == h-1 && cur[1] == w-1) {
                System.out.println(time);
                return;
            }
            for(int[] dir : direction[cur[0]%2]) {
                int newH = cur[0] + dir[0];
                int newW = cur[1] + dir[1];
                if(newH < 0 || newH >= h || newW < 0 || newW >= w || visited[newH][newW]) continue;
                visited[newH][newW] = true;
                q.add(new int[]{newH, newW, time+1});
            }
        }
        System.out.println(-1);
    }
}
