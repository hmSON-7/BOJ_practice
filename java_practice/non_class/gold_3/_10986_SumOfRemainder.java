package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10986_SumOfRemainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[mod];
        int sum = 0;
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken())%mod;
            sum = (sum+x)%mod;
            arr[sum]++;
        }
        long cnt = arr[0];
        for(int i=0; i<arr.length; i++) {
            cnt += (long)arr[i] * (arr[i]-1)/2;
        }
        System.out.println(cnt);
    }
}
