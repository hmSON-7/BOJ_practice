package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_Sum_of_Subsequence {
    static int n, target, cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve(0, 0, 0);
        System.out.println(cnt);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve(int idx, int numCnt, int sum) {
        if(numCnt > 0 && sum == target) cnt++;

        for(int i=idx; i<n; i++) {
            solve(i+1, numCnt+1, sum + arr[i]);
        }
    }
}
