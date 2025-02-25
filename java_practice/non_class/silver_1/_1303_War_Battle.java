package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1303_War_Battle {
    public static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        boolean[][] visited = new boolean[h][w];
        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        int white = 0, blue = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;
                q.add(new int[]{i, j});
                int p = bfs(h, w, map, visited, q);
                if(map[i][j] == 'W') white += (int)Math.pow(p, 2);
                else blue += (int)Math.pow(p, 2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(white).append(" ").append(blue);
        System.out.println(sb);
    }

    static int bfs(int h, int w, char[][] map, boolean[][] visited, Queue<int[]> q) {
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            cnt++;
            for(int[] dir : direction) {
                int newY = y + dir[0], newX = x + dir[1];
                if(newY < 0 || newX < 0 || newY >= h || newX >= w || visited[newY][newX]) continue;
                if(map[newY][newX] != map[y][x]) continue;
                visited[newY][newX] = true;
                q.add(new int[]{newY, newX});
            }
        }
        return cnt;
    }
}
