package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14500_Tetromino {
    static int h, w, max = 0;
    static int[][] table;
    static int[][][] tetrominoes = {
            // 직선
            {{0,0}, {0,1}, {0,2}, {0,3}},  // ㅡ
            {{0,0}, {1,0}, {2,0}, {3,0}},  // ㅣ

            // 정사각형
            {{0,0}, {0,1}, {1,0}, {1,1}},  // ㅁ

            // L자 모양
            {{0,0}, {1,0}, {2,0}, {2,1}},  // 기본 L (회전)
            {{0,1}, {1,1}, {2,1}, {2,0}},
            {{0,0}, {0,1}, {0,2}, {1,0}},
            {{0,0}, {0,1}, {0,2}, {1,2}},
            {{0,0}, {1,0}, {1,1}, {1,2}},  // 반전 L
            {{0,2}, {1,2}, {1,1}, {1,0}},
            {{0,0}, {1,0}, {2,0}, {0,1}},
            {{0,0}, {0,1}, {1,1}, {2,1}},

            // S자 모양
            {{0,0}, {0,1}, {1,1}, {1,2}},  // 기본 S (회전)
            {{0,1}, {1,1}, {1,0}, {2,0}},
            {{0,0}, {1,0}, {1,1}, {2,1}},  // 반전 S
            {{0,1}, {0,2}, {1,0}, {1,1}},

            // T자 모양
            {{0,0}, {0,1}, {0,2}, {1,1}},  // ㅗ
            {{0,1}, {1,0}, {1,1}, {2,1}},  // ㅓ
            {{1,0}, {1,1}, {1,2}, {0,1}},  // ㅜ
            {{0,0}, {1,0}, {2,0}, {1,1}},  // ㅏ
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        h = Integer.parseInt(info[0]);
        w = Integer.parseInt(info[1]);
        table = new int[h][w];
        for(int i=0; i<h; i++) {
            String[] line = br.readLine().trim().split(" ");
            for(int j=0; j<w; j++) {
                table[i][j] = Integer.parseInt(line[j]);
            }
        }
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                checkTetromino(i, j);
            }
        }
        System.out.println(max);
    }

    static void checkTetromino(int y, int x) {
        for(int[][] shape : tetrominoes) {
            int sum = 0;
            boolean valid = true;
            for(int[] block : shape) {
                int newY = y + block[0];
                int newX = x + block[1];
                if(newY < 0 || newX < 0 || newY >= h || newX >= w) {
                    valid = false; break;
                }
                sum += table[newY][newX];
            }
            if(valid) max = Math.max(max, sum);
        }
    }
}
