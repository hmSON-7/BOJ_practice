package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2740_MatrixMultiplication {
    static int r1, c1, r2, c2;
    static int[][] matrix1, matrix2;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        matrix1 = new int[r1][c1];
        for(int i=0; i<r1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c1; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        matrix2 = new int[r2][c2];
        for(int i=0; i<r2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c2; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r1; i++) {
            for(int j=0; j<c2; j++) {
                sb.append(getSum(i,j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int getSum(int row, int col) {
        int sum = 0;
        for(int i=0; i<r2; i++) {
            sum += matrix1[row][i] * matrix2[i][col];
        }
        return sum;
    }
}
