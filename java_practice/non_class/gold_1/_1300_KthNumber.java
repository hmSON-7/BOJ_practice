package gold_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1300_KthNumber {
    static int n, k;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve(1, (int)Math.min((long)n*n, 1e9)));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    private static int solve(int start, int end) {
        if(start > end) return start;

        int mid = (start + end)/2;
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            cnt += Math.min(n, (mid / i));
        }
        return cnt < k ? solve(mid+1, end) : solve(start, mid-1);
    }
}
