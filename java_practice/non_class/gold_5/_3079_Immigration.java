package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3079_Immigration {
    static int n, m, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            if(x > max) max = x;
        }
    }

    private static void solve() {
        long left = 1, right = (long)m * max;
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i=0; i<n; i++) {
                sum += mid / arr[i];
                if(sum >= m) break;
            }
            if(sum >= m) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }
}
