package Rank3.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3D {
    int height, col, row, date;

    public Point3D(int height, int col, int row, int date) {
        this.height = height;
        this.col = col;
        this.row = row;
        this.date = date;
    }
}

public class _7569_Tomato {
    static int[][] direction = new int[][]{
            {-1, 0, 0}, {1, 0, 0}, {0, -1, 0},
            {0, 1, 0}, {0, 0, -1}, {0, 0, 1}
    };
    static int r, c, h;
    static int[][][] table;
    static Queue<Point3D> q = new LinkedList<>();
    static int unripeCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        table = new int[h][c][r];
        for(int i=0; i<h; i++) {
            for(int j=0; j<c; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<r; k++) {
                    table[i][j][k] = Integer.parseInt(st.nextToken());
                    if(table[i][j][k] == 1) q.add(new Point3D(i, j, k, 0));
                    else if(table[i][j][k] == 0) unripeCnt++;
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int totalDate = 0;
        while(!q.isEmpty()) {
            Point3D p = q.poll();
            totalDate = p.date;

            for(int[] dir : direction) {
                int newH = p.height + dir[0];
                int newC = p.col + dir[1];
                int newR = p.row + dir[2];
                if(newH < 0 || newC < 0 || newR < 0 || newH >= h || newC >= c || newR >= r ||
                        table[newH][newC][newR] != 0) continue;
                unripeCnt--;
                table[newH][newC][newR] = 1;
                q.add(new Point3D(newH, newC, newR, p.date + 1));
            }
        }

        if(unripeCnt != 0) return -1;
        return totalDate;
    }
}
