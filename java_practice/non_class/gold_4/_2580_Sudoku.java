package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2580_Sudoku {
    static int[][] table = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        playSudoku(0, 0);
    }

    static void playSudoku(int h, int w) {
        if(w == 9) {
            playSudoku(h+1, 0);
            return;
        }
        if(h == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(table[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(table[h][w] == 0) {
            for(int i=1; i<=9; i++) {
                if(checkNumber(h, w, i)) {
                    table[h][w] = i;
                    playSudoku(h, w+1);
                }
            }
            table[h][w] = 0;
            return;
        }
        playSudoku(h, w+1);
    }

    static boolean checkNumber(int h, int w, int value) {
        for(int i=0; i<9; i++) {
            if(table[i][w] == value) {
                return false;
            }
        }
        for(int i=0; i<9; i++) {
            if(table[h][i] == value) {
                return false;
            }
        }
        int setH = (h/3) * 3, setW = (w/3) * 3;
        for(int i=setH; i<setH + 3; i++) {
            for(int j=setW; j<setW + 3; j++) {
                if(table[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
