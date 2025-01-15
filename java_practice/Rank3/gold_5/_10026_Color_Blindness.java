package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026_Color_Blindness {
    static char[][] table;
    static int n;
    static boolean[][] visitNormal;
    static boolean[][] visitBlind;
    static int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new char[n][n];
        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            table[i] = line;
        }
        visitNormal = new boolean[n][n];
        visitBlind = new boolean[n][n];

        int cntNormal = 0, cntBlind = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visitNormal[i][j]) {
                    q.add(new int[]{i, j});
                    visitNormal[i][j] = true;
                    bfsNormal(table[i][j]);
                    cntNormal++;
                }
                if(!visitBlind[i][j]) {
                    q.add(new int[]{i, j});
                    visitBlind[i][j] = true;
                    bfsBlind(table[i][j] == 'B');
                    cntBlind++;
                }
            }
        }

        System.out.println(cntNormal + " " + cntBlind);
    }

    static void bfsNormal(char c) {
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir : direction) {
                int y = pos[0] + dir[0];
                int x = pos[1] + dir[1];
                if(y<0 || x<0 || y>=n || x>=n || visitNormal[y][x] || table[y][x] != c) continue;
                visitNormal[y][x] = true;
                q.add(new int[]{y, x});
            }
        }
    }

    static void bfsBlind(boolean isBlue) {
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir : direction) {
                int y = pos[0] + dir[0];
                int x = pos[1] + dir[1];
                if(y<0 || x<0 || y>=n || x>=n || visitBlind[y][x]) continue;
                if((isBlue && table[y][x] != 'B') || (!isBlue && table[y][x] == 'B')) continue;
                visitBlind[y][x] = true;
                q.add(new int[]{y, x});
            }
        }
    }
}
