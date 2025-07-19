package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054_TheLongest_BitonicSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] right_dp = new int[n];
        for(int i=0; i<n; i++) {
            right_dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i] && right_dp[i] < right_dp[j] + 1) {
                    right_dp[i] = right_dp[j] + 1;
                }
            }
        }
        int[] left_dp = new int[n];
        for(int i=n-1; i>=0; i--) {
            left_dp[i] = 1;
            for(int j=n-1; j>i; j--) {
                if(arr[j] < arr[i] && left_dp[i] < left_dp[j] + 1) {
                    left_dp[i] = left_dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, left_dp[i] + right_dp[i]);
        }
        System.out.println(max-1);
    }
}
