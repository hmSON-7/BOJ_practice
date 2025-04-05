package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273_SumOfTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0, right = n-1, cnt = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == x) {
                cnt++;
                left++; right--;
            }
            else if(sum < x) left++;
            else right--;
        }
        System.out.println(cnt);
    }
}
