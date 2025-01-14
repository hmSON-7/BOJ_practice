import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3D {
    int height, row, col, date;

    public Point3D(int height, int row, int col, int date) {
        this.height = height;
        this.row = row;
        this.col = col;
        this.date = date;
    }
}

public class Main {
    static int[][] direction = new int[][]{
            {-1, 0, 0}, {1, 0, 0}, {0, -1, 0},
            {0, 1, 0}, {0, 0, -1}, {0, 0, 1}
    };
    static int r, c, h;
    static int[][][] table;
    static Queue<Point3D> q = new LinkedList<>();

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
                table[newH][newC][newR] = 1;
                q.add(new Point3D(newH, newC, newR, p.date + 1));
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<c; j++) {
                for(int k=0; k<r; k++) {
                    if(table[i][j][k] == 0) {
                        totalDate = -1;
                        break;
                    }
                }
            }
        }

        return totalDate;
    }
}
