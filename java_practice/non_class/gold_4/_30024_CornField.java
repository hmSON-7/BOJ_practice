package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _30024_CornField {
    public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] field = new int[h+1][w+1];
        boolean[][] visited = new boolean[h+1][w+1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        for(int i=1; i<=h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=w; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(i == 1 || j == 1 || i == h || j == w) {
                    q.add(new int[]{i, j, field[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int total = Integer.parseInt(br.readLine()), cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int[] p = q.poll();
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
            cnt++;
            if(cnt == total) break;
            for(int[] dir : directions) {
                int newH = p[0] + dir[0];
                int newW = p[1] + dir[1];
                if(newH < 1 || newH > h || newW < 1 || newW > w || visited[newH][newW]) continue;
                q.add(new int[]{newH, newW, field[newH][newW]});
                visited[newH][newW] = true;
            }
        }
        System.out.println(sb);
    }
}
