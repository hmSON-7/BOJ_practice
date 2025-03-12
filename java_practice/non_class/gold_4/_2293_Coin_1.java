package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2293_Coin_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[total+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int x : arr) {
            if(x > total) continue;
            dp[x]++;
            for(int i=x+1; i<=total; i++) {
                dp[i] = dp[i] + dp[i-x];
            }
        }
        System.out.println(dp[total]);
    }
}
