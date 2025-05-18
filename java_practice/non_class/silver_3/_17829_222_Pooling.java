package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17829_222_Pooling {
    static int n;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve(n, 0, 0));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solve(int part, int y, int x) {
        if(part == 1) return matrix[y][x];
        int[] res = new int[4];
        int middle = part / 2;
        res[0] = solve(middle, y, x);
        res[1] = solve(middle, y, x+middle);
        res[2] = solve(middle, y+middle, x);
        res[3] = solve(middle, y+middle, x+middle);
        Arrays.sort(res);
        return res[2];
    }
}
