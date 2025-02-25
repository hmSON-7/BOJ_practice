package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_Fire {
    public static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        int[][] fireTime = new int[h][w];
        int[][] exitTime = new int[h][w];
        for(int i=0; i<h; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
            Arrays.fill(exitTime[i], -1);
        }
        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> exitQ = new ArrayDeque<>();
        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
                if(map[i][j] == 'J') {
                    exitQ.add(new int[]{i, j});
                    exitTime[i][j] = 0;
                }
            }
        }
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int curH = cur[0], curW = cur[1];
            for (int[] dir : direction) {
                int newH = curH + dir[0], newW = curW + dir[1];
                if (newH < 0 || newH >= h || newW < 0 || newW >= w) continue;
                if (map[newH][newW] == '#' || fireTime[newH][newW] != Integer.MAX_VALUE) continue;
                fireTime[newH][newW] = fireTime[curH][curW] + 1;
                fireQ.add(new int[]{newH, newW});
            }
        }
        while (!exitQ.isEmpty()) {
            int[] cur = exitQ.poll();
            int curH = cur[0], curW = cur[1];
            if (curH == 0 || curH == h - 1 || curW == 0 || curW == w - 1) {
                System.out.println(exitTime[curH][curW] + 1);
                return;
            }
            for (int[] dir : direction) {
                int newH = curH + dir[0], newW = curW + dir[1];
                if (map[newH][newW] == '#' || exitTime[newH][newW] != -1) continue;
                if (exitTime[curH][curW] + 1 >= fireTime[newH][newW]) continue;
                exitTime[newH][newW] = exitTime[curH][curW] + 1;
                exitQ.add(new int[]{newH, newW});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
