package Rank4.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15652_NandM4 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        arr = new int[n+1];

        bt(0, 1);
        System.out.println(sb);
    }

    static void bt(int idx, int x) {
        if(idx == m) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=x; i<=n; i++) {
            arr[idx] = i;
            bt(idx+1, i);
        }
    }
}
