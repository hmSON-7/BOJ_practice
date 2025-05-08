package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10830_MatrixExponentiation {
    static int n;
    static long e;
    static HashMap<Long, int[][]> map = new HashMap<>();
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
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        map.put(1L, matrix);
    }

    private static int[][] solve(long x) {
        if(x == 1 || map.containsKey(x)) return map.get(x);
        int[][] half = solve(x/2);
        int[][] res = multiply(half, half);
        if(x%2 != 0) res = multiply(res, solve(1));
        map.put(x, res);
        return res;
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
