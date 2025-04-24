package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1744_LashingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int total = 0, left = 0, right = arr.length - 1;
        while(left < right && arr[right-1] > 1) {
            total += arr[right--] * arr[right--];
        }
        while(left < right && arr[left+1] < 1) {
            total += arr[left++] * arr[left++];
        }
        while(left <= right) total += arr[left++];
        System.out.println(total);
    }
}
