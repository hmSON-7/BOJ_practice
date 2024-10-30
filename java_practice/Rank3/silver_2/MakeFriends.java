package silver_2;

import java.io.*;
import java.util.*;

public class MakeFriends {
    static String[][] campus;
    static boolean[][] visit;
    static int row, col;

    static Queue<int []> q = new LinkedList<>();
    static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        row = Integer.parseInt(info[0]);
        col = Integer.parseInt(info[1]);

        campus = new String[row][col];
        visit = new boolean[row][col];
        int[] yourLoc;
        for(int i=0; i<row; i++) {
            campus[i] = br.readLine().trim().split("");
            int yourCol = findYourLocation(campus[i]);
            if(yourCol != -1) {
                yourLoc = new int[]{i, yourCol};
                visit[i][yourCol] = true;
                q.add(yourLoc);
            }
        }

        int cntPerson = bfs();
        if(cntPerson == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cntPerson);
        }
    }

    static int findYourLocation(String[] line) {
        for(int i=0; i<line.length; i++) {
            if(line[i].equals("I")) {
                return i;
            }
        }

        return -1;
    }

    static int bfs() {
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if(x<0 || y<0|| x>=row || y>=col) {
                    continue;
                }

                if(visit[x][y] || campus[x][y].equals("X")) {
                    continue;
                }

                q.add(new int[]{x, y});
                visit[x][y] = true;
                if(campus[x][y].equals("P")) cnt++;
            }
        }

        return cnt;
    }
}
