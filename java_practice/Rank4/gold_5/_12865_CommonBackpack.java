package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_CommonBackpack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[] weights = new int[n+1];
        int[] values = new int[n+1];
        int[] dp = new int[maxWeight+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++) {
            for(int j=maxWeight; j-weights[i]>=0; j--) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }
        System.out.println(dp[maxWeight]);
    }
}
