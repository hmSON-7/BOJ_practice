package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343_GuitarLesson {
    static int n, b, max = 0, sum = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        if(b == 1) System.out.println(sum);
        else if(b == n) System.out.println(max);
        else System.out.println(solve(max, sum-1));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sum += x;
            max = Math.max(max, x);
        }
    }

    private static int solve(int left, int right) {
        if(left > right) return left;

        int mid = (left + right) / 2;
        int sum = 0, cnt = 0;
        for(int i=0; i<n; i++) {
            int x = arr[i];
            if(sum + x > mid) {
                cnt++;
                sum = x;
            } else sum += x;
            if(cnt > b) return solve(mid+1, right);
        }
        cnt++;
        if(cnt > b) return solve(mid+1, right);
        else return solve(left, mid-1);
    }
}
