package gold_4;

import java.io.*;
import java.util.*;

public class _14499_RollingDice {
    static int r, c, y, x, cmdCnt;
    static int[][] map;
    static int[] diceIdx = {0, 1, 2, 3, 4, 5}, diceValue = new int[6];
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0}, cmds;
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        cmdCnt = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cmds = new int[cmdCnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cmdCnt; i++) {
            cmds[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for(int cmd : cmds) {
            int newY = y + dy[cmd];
            int newX = x + dx[cmd];
            if(!isIn(newY, newX)) continue;
            spin(cmd);
            y = newY; x = newX;
            int bottomIdx = diceIdx[0], topIdx = diceIdx[5];
            if(map[y][x] == 0) map[y][x] = diceValue[bottomIdx];
            else {
                diceValue[bottomIdx] = map[y][x];
                map[y][x] = 0;
            }

            sb.append(diceValue[topIdx]).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < r && x < c;
    }

    public static void spin(int dir) {
        int temp = diceIdx[0];
        switch(dir) {
            case 0 :
                diceIdx[0] = diceIdx[1];
                diceIdx[1] = diceIdx[5];
                diceIdx[5] = diceIdx[2];
                diceIdx[2] = temp;
                break;
            case 1 :
                diceIdx[0] = diceIdx[2];
                diceIdx[2] = diceIdx[5];
                diceIdx[5] = diceIdx[1];
                diceIdx[1] = temp;
                break;
            case 2 :
                diceIdx[0] = diceIdx[3];
                diceIdx[3] = diceIdx[5];
                diceIdx[5] = diceIdx[4];
                diceIdx[4] = temp;
                break;
            case 3 :
                diceIdx[0] = diceIdx[4];
                diceIdx[4] = diceIdx[5];
                diceIdx[5] = diceIdx[3];
                diceIdx[3] = temp;
        }
    }
}