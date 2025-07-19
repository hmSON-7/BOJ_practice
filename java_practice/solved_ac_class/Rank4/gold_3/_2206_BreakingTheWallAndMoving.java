package Rank4.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_BreakingTheWallAndMoving {
    static int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][] visitedWithoutBreak = new boolean[h][w];
        boolean[][] visitedWithBreak = new boolean[h][w];

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 1, false));
        visitedWithoutBreak[0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == h-1 && p.x == w-1) {
                System.out.println(p.cnt);
                return;
            }
            for (int[] d : directions) {
                int ny = p.y + d[0];
                int nx = p.x + d[1];
                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(!p.breakFlag) {
                    if(map[ny][nx] == 0 && !visitedWithoutBreak[ny][nx]) {
                        visitedWithoutBreak[ny][nx] = true;
                        q.add(new Point(ny, nx, p.cnt + 1, false));
                    }
                    if(map[ny][nx] == 1 && !visitedWithBreak[ny][nx]) {
                        visitedWithBreak[ny][nx] = true;
                        q.add(new Point(ny, nx, p.cnt + 1, true));
                    }
                } else {
                    if(map[ny][nx] == 0 && !visitedWithBreak[ny][nx]) {
                        visitedWithBreak[ny][nx] = true;
                        q.add(new Point(ny, nx, p.cnt + 1, true));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Point {
    int y, x, cnt;
    boolean breakFlag;

    public Point(int y, int x, int cnt, boolean breakFlag) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.breakFlag = breakFlag;
    }
}