package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963_HowManyIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            boolean[][] visited = new boolean[h+2][w+2];
            boolean[][] map = new boolean[h+2][w+2];
            for(int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=1; j<=w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                    visited[i][j] = !map[i][j];
                }
            }
            int cnt = 0;
            for(int i=1; i<=h; i++) {
                for(int j=1; j<=w; j++) {
                    if(visited[i][j]) continue;
                    visit(map, visited, i, j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void visit(boolean[][] map, boolean[][] visited, int y, int x) {
        if(!map[y][x] || visited[y][x]) return;
        visited[y][x] = true;
        visit(map, visited, y+1, x);
        visit(map, visited, y-1, x);
        visit(map, visited, y, x+1);
        visit(map, visited, y, x-1);
        visit(map, visited, y+1, x+1);
        visit(map, visited, y+1, x-1);
        visit(map, visited, y-1, x+1);
        visit(map, visited, y-1, x-1);
    }
}
