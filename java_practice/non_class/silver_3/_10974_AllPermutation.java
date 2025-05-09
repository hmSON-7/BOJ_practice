package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974_AllPermutation {
    static int n;
    static int[] arr, res;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        arr = new int[n];
        res = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        bt(0);
        System.out.println(sb);
    }

    private static void bt(int idx) {
        if(idx == n) {
            for(int i=0; i<n; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            res[idx] = arr[i];
            bt(idx+1);
            visited[i] = false;
        }
    }
}
