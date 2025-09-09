package Rank3.silver_3;

import java.io.*;

public class Main_2579 {

	static int[] arr;
    static int[] dp = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // �� ����� ���� �迭
        arr = new int[t+1];
        // �� ��ܱ��� �ö��� ���� �ִ밪
        dp = new int[t+1];
        for(int i=1; i<=t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // �ʱⰪ ����
        dp[0] = 0; dp[1] = arr[1];
        if(arr.length > 2) {
            dp[2] = arr[1] + arr[2];
        }
        // � ����� ��� ���ؼ��� �ٷ� �Ʒ��� �ִ� �� ��� �� �ϳ��� �ǳʶپ�߸� �Ѵ�.
        // �̸� �̿��� �ٷ� �Ʒ��� �� ��� �� � ���� �ǳʶپ��� �� �� ����������� �Ǵ��Ѵ�.
        for(int i=3; i<=t; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        System.out.println(dp[t]);
    }
}
