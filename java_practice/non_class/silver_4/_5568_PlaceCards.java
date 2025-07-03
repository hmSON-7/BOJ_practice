package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _5568_PlaceCards {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] arr, selected;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        read(); solve(0);
        System.out.println(set.size());
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[k];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve(int cnt) {
        if(cnt == k) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<k; i++) {
                sb.append(selected[i]);
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[cnt] = arr[i];
                solve(cnt+1);
                visited[i] = false;
            }
        }
    }
}
