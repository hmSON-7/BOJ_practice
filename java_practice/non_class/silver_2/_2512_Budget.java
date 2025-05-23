package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2512_Budget {
    static int n, total, sum = 0, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        if(sum <= total) System.out.println(max);
        else {
            System.out.println(solve(total/n, max-1));
        }
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sum += x;
            max = Math.max(max, x);
        }
        total = Integer.parseInt(br.readLine());
    }

    private static int solve(int left, int right) {
        if(left > right) return right;
        int limit = (left + right) / 2;
        sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.min(arr[i], limit);
        }
        return sum <= total ? solve(limit+1, right) : solve(left, limit-1);
    }
}
