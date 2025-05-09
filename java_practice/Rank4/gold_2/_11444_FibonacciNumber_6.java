package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11444_FibonacciNumber_6 {
    static long n;
    public static void main(String[] args) throws IOException {
        read();
        int[][] first = {{1, 1}, {1, 0}};
        int[][] res = solve(first, n-1);
        System.out.println(res[0][0]);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
    }

    private static int[][] solve(int[][] matrix, long x) {
        if(x == 0) return new int[][]{{1, 0}, {0, 1}};
        int[][] half = solve(matrix, x/2);
        int[][] res = multiply(half, half);
        return x%2 == 1 ? multiply(res, matrix) : res;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[2][2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                long sum = 0;
                for(int k=0; k<2; k++) {
                    sum += (long)a[i][k] * b[k][j];
                }
                res[i][j] = (int)(sum%1000000007);
            }
        }
        return res;
    }
}
