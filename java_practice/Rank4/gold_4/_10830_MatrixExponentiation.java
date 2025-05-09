package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830_MatrixExponentiation {
    static int n;
    static long e;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        read();
        int[][] res = solve(e);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Long.parseLong(st.nextToken());
        matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
    }

    private static int[][] solve(long x) {
        if(x == 1) return matrix;
        int[][] half = solve(x/2);
        int[][] res = multiply(half, half);
        return x%2 == 1 ? multiply(res, matrix) : res;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int sum = 0;
                for(int k=0; k<n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = sum%1000;
            }
        }
        return res;
    }
}
