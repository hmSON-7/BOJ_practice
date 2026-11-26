package gold_1;

import java.io.*;
import java.util.*;

public class Main_13460 {

    static int r, c;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int red = -1, blue = -1, hole = -1;

        map = new char[r][c];
        for(int i=0; i<r; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<c; j++) {
                char ch = line[j];
                if(ch == 'R') {
                    red = i * c + j;
                    ch = '.';
                } else if(ch == 'B') {
                    blue = i * c + j;
                    ch = '.';
                } else if(ch == 'O') {
                    hole = i * c + j;
                }

                map[i][j] = ch;
            }
        }

        boolean[][] visited = new boolean[r*c][r*c];
        visited[red][blue] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{red, blue, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRed = cur[0], curBlue = cur[1];

            for(int i=0; i<4; i++) {
                int destRed = getDest(curRed, i);
                int destBlue = getDest(curBlue, i);
                if(destBlue == hole) {
                    continue;
                } else if(destRed == hole) {
                    System.out.println(cur[2] + 1);
                    return;
                }

                if(cur[2] == 9) continue;

                if(destRed == destBlue) {
                    int correctionVal = (destRed/c - dy[i]) * c + (destRed%c - dx[i]);
                    int projRed = (curRed/c) * dy[i] + (curRed%c) * dx[i];
                    int projBlue = (curBlue/c) * dy[i] + (curBlue%c) * dx[i];

                    if(projRed >= projBlue) {
                        destBlue = correctionVal;
                    } else {
                        destRed = correctionVal;
                    }
                }

                if(visited[destRed][destBlue]) continue;
                visited[destRed][destBlue] = true;
                q.add(new int[]{destRed, destBlue, cur[2] + 1});
            }
        }

        System.out.println(-1);
    }

    static int getDest(int bead, int dir) {
        int y = bead / c, x = bead % c;
        while(map[y+dy[dir]][x+dx[dir]] != '#') {
            y += dy[dir];
            x += dx[dir];

            if(map[y][x] == 'O') break;
        }

        return y * c + x;
    }

}