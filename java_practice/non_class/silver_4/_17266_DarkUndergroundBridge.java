package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17266_DarkUndergroundBridge {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int minHeight = Math.max(arr[0], n - arr[m-1]);
        for(int i=0; i<m-1; i++) {
            int dist = arr[i+1] - arr[i];
            int h = dist / 2 + (dist % 2 == 0 ? 0 : 1);
            if(h > minHeight) minHeight = h;
        }
        System.out.println(minHeight);
    }
}
