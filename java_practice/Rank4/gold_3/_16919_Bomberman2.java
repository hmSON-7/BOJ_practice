package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16919_Bomberman2 {
    static int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][][] map;
    static int h, w, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new char[3][h][w];
        for(int i = 0; i < h; i++) {
            map[0][i] = br.readLine().toCharArray();
        }
        for(int i=0; i<2; i++) {
            setBomb(i, i+1);
        }

        if(t%2 == 0) {
            for(int i=0; i<h; i++) {
                sb.append("O".repeat(w));
                sb.append('\n');
            }
        } else {
            int idx = t == 1 ? 0 : t % 4 == 3 ? 1 : 2;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    sb.append(map[idx][i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void setBomb(int x1, int x2) {
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[x1][i][j] == 'O') {
                    map[x2][i][j] = '.';
                    for(int[] dir : direction) {
                        int newH = i+dir[0];
                        int newW = j+dir[1];
                        if(newH >= 0 && newH < h && newW >= 0 && newW < w) map[x2][newH][newW] = '.';
                    }
                }
            }
        }
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[x2][i][j] != '.') map[x2][i][j] = 'O';
            }
        }
    }
}
