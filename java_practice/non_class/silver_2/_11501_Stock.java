package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11501_Stock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long profit = getProfit(n, arr);
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }

    private static long getProfit(int n, int[] arr) {
        int idx = 0, start = 0, max;
        long profit = 0;
        while(idx < n -1) {
            max = 0; start = idx;
            for(int i = idx; i< n; i++) {
                int x = arr[i];
                max = Math.max(max, x);
                if(max == x) idx = i;
            }
            int cnt = 0; long cost = 0;
            for(int i=start; i<idx; i++) {
                cost += arr[i];
                cnt++;
            }
            profit += ((long) cnt * max) - cost;
            idx++;
        }
        return profit;
    }
}
