package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24460_SpecialAward {
    static int n;
    static int[][] chairs;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve(n, 0, 0));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chairs = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                chairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solve(int x, int r, int c) {
        if(x == 1) return chairs[r][c];
        int half = x/2;
        int[] res = new int[4];
        res[0] = solve(half, r, c);
        res[1] = solve(half, r+half, c);
        res[2] = solve(half, r, c+half);
        res[3] = solve(half, r+half, c+half);

        Arrays.sort(res);
        return res[1];
    }
}
