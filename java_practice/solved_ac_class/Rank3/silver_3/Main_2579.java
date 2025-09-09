package Rank3.silver_3;

import java.io.*;

public class Main_2579 {

	static int[] arr;
    static int[] dp = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // 각 계단의 점수 배열
        arr = new int[t+1];
        // 각 계단까지 올라갔을 때의 최대값
        dp = new int[t+1];
        for(int i=1; i<=t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        dp[0] = 0; dp[1] = arr[1];
        if(arr.length > 2) {
            dp[2] = arr[1] + arr[2];
        }
        // 어떤 계단을 밟기 위해서는 바로 아래에 있는 두 계단 중 하나를 건너뛰어야만 한다.
        // 이를 이용해 바로 아래의 두 계단 중 어떤 것을 건너뛰었을 때 더 고득점인지를 판단한다.
        for(int i=3; i<=t; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        System.out.println(dp[t]);
    }
}
