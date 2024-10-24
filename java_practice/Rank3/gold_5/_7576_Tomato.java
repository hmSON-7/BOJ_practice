package gold_5;

import java.util.*;
import java.io.*;

public class _7576_Tomato {
    static int[][] map = null;
    static int w;
    static int h;
    static int total = 0, tomatoCnt = 0;
    static int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        w = Integer.parseInt(info[0]);
        h = Integer.parseInt(info[1]);
        map = new int[h][w];
        for(int i=0; i<h; i++) {
            String[] tomato = br.readLine().trim().split(" ");
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(tomato[j]);
                if(map[i][j] != -1) {
                    total++;
                }

                if(map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    tomatoCnt++;
                }
            }
        }

        int res = Algorithm();
        System.out.println(res);
    }

    static int Algorithm() {
        int currentTime = 0;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            currentTime = current[2];
            for(int i=0; i<4; i++) {
                int y = current[0] + direction[i][0];
                int x = current[1] + direction[i][1];

                if(x<0 || y<0 || x>=w || y>=h || map[y][x] != 0) {
                    continue;
                }

                q.add(new int[]{y, x, currentTime + 1});
                map[y][x] = 1;
                tomatoCnt++;
            }
        }

        if(total == tomatoCnt) return currentTime;
        else return -1;
    }
}
