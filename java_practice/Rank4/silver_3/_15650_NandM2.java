package silver_3;

import java.io.*;

public class _15650_NandM2 {
    static int n, sel;
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split( " ");
        n = Integer.parseInt(info[0]);
        sel = Integer.parseInt(info[1]);
        visit = new boolean[n+1];
        arr = new int[n+1];

        bt(0, 1);
        System.out.println(sb);
    }

    static void bt(int idx, int x) {
        if(idx == sel) {
            for(int i=0; i<sel; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=x; i<=n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[idx] = i;
            bt(idx+1, i);
            visit[i] = false;
        }
    }
}
