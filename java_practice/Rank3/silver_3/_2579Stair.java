import java.io.*;

public class _2579Stair {
    static int[] arr = null;
    static int[] dp = null;
    public static int calc(int n) {
        if(dp[n+1] == 0) {
            return Math.max(dp[n-1], dp[n-2] + arr[n-1]) + arr[n];
        } return dp[n+1];
    }
    public static void main(String[] args) throws IOException {
        // 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[t];
        dp = new int[t+1];
        for(int i=0; i<t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0; dp[1] = arr[0];
        if(arr.length >= 2) {
            dp[2] = arr[0] + arr[1];
        }
        for(int i=2; i<t; i++) {
            dp[i+1] = calc(i);
        }

        System.out.println(dp[t]);
    }
}
