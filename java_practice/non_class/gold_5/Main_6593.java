package gold_5;

import java.io.*;
import java.util.*;

public class Main_6593 {

    static int l, r, c, sz, sy, sx, ez, ey, ex;
    static boolean[][][] isWall;
    static int[] dz = {1, -1, 0, 0, 0, 0}, dy = {0, 0, -1, 0, 1, 0}, dx = {0, 0, 0, 1, 0, -1};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l == 0 && r == 0 && c == 0) break;

            String line;
            isWall = new boolean[l][r][c];
            for(int i=0; i<l; i++) {
                for(int j=0; j<r; j++) {
                    line = br.readLine();
                    for(int k=0; k<c; k++) {
                        char ch = line.charAt(k);
                        if(ch == 'S') {
                            sz = i;
                            sy = j;
                            sx = k;
                        } else if(ch == 'E') {
                            ez = i;
                            ey = j;
                            ex = k;
                        }

                        isWall[i][j][k] = ch == '#';
                    }
                }

                br.readLine();
            }

            int time = bfs();
            if(time == -1) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in ").append(time).append(" minute(s).");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int bfs() {
        q.clear();
        q.add(new int[]{sz, sy, sx, 0});
        isWall[sz][sy][sx] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<6; i++) {
                int z = cur[0] + dz[i];
                int y = cur[1] + dy[i];
                int x = cur[2] + dx[i];
                if(!isIn(z, y, x) || isWall[z][y][x]) continue;
                if(isEnd(z, y, x)) return cur[3] + 1;

                isWall[z][y][x] = true;
                q.add(new int[]{z, y, x, cur[3] + 1});
            }
        }

        return -1;
    }

    static boolean isIn(int z, int y, int x) {
        return z >= 0 && z < l && y >= 0 && y < r && x >= 0 && x < c;
    }

    static boolean isEnd(int z, int y, int x) {
        return z == ez && y == ey && x == ex;
    }

}