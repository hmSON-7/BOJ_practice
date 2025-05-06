package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16435_SnakeBird {
    static int n, len;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        solve();
        System.out.println(len);
    }

    private static void read() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        for(int i=0; i<n; i++) {
            int x = arr[i];
            if(len < x) break;
            len++;
        }
    }
}
