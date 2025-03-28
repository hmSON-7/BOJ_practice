package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_QuadTree {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        quadTree(n, 0, 0);
        System.out.println(sb);
    }

    static void quadTree(int n, int r, int c) {
        char curr = arr[r][c];
        if(n == 1 || press(curr, n, r, c)) {
            sb.append(curr);
            return;
        }
        sb.append("(");
        int midRow = r + (n/2), midCol = c + (n/2);
        quadTree(n/2, r, c);
        quadTree(n/2, r, midCol);
        quadTree(n/2, midRow, c);
        quadTree(n/2, midRow, midCol);
        sb.append(")");
    }

    static boolean press(char curr, int n, int r, int c) {
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(curr != arr[i][j]) return false;
            }
        }
        return true;
    }
}
