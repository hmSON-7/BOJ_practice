package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_Lotto {
    static final int SELECT_SIZE = 6;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] lotto;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            lotto = new int[n];
            visited = new boolean[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            bt(arr, n, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bt(int[] arr, int n, int idx, int x) {
        if(idx == SELECT_SIZE) {
            for(int i=0; i<SELECT_SIZE; i++) {
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=x; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            lotto[idx] = arr[i];
            bt(arr, n, idx+1, i+1);
            visited[i] = false;
        }
    }
}
