package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003_SumOfNumbers_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0, left = 0, right = 0, cnt = 0;
        while(right < n) {
            sum += arr[right++];
            if(sum < m) continue;
            while(sum > m) sum -= arr[left++];
            if(sum == m) cnt++;
        }
        System.out.println(cnt);
    }
}
