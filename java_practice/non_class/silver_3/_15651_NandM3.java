package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15651_NandM3 {
    static int n, sel;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split( " ");
        n = Integer.parseInt(info[0]);
        sel = Integer.parseInt(info[1]);
        arr = new int[n+1];

        bt(0);
        System.out.println(sb);
    }

    static void bt(int idx) {
        if(idx == sel) {
            for(int i=0; i<sel; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            arr[idx] = i;
            bt(idx+1);
        }
    }
}
