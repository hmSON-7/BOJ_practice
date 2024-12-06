package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11053_TheLongestIncreasingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        String[] line = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
