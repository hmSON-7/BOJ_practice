package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int col;
    int row;
    int dir;

    public Point(int col, int row, int dir) {
        this.col = col;
        this.row = row;
        this.dir = dir;
    }
}

public class _14940_ShortestDirection {
    static final int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visit;
    static int[][] table;
    static Queue<Point> q = new LinkedList<>();
    static int col, row;
    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] info = br.readLine().trim().split(" ");
        col = Integer.parseInt(info[0]);
        row = Integer.parseInt(info[1]);
        visit = new boolean[col][row];
        table = new int[col][row];
        StringTokenizer st;
        for(int i=0; i<col; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<row; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if(table[i][j] == 2) {
                    visit[i][j] = true;
                    q.add(new Point(i, j, 0));
                } else if(table[i][j] == 1) {
                    table[i][j] = -1;
                }
            }
        }
        bfs();

        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                sb.append(table[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();
            table[p.col][p.row] = p.dir;
            for(int[] d : direction) {
                int newCol = p.col + d[0];
                int newRow = p.row + d[1];
                if((newCol < 0 || newRow < 0 || newCol >= col || newRow >= row)
                        || visit[newCol][newRow] || table[newCol][newRow] == 0) {
                    continue;
                }

                q.add(new Point(newCol, newRow, p.dir + 1));
                visit[newCol][newRow] = true;
            }
        }
    }
}
