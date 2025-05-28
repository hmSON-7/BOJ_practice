package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2467_Solution {
    static int n, minDiff = Integer.MAX_VALUE, sol1, sol2;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
        System.out.println(arr[sol1] + " " + arr[sol2]);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        int left = 0, right = n-1;
        while(left < right) {
            int n1 = arr[left], n2 = arr[right];
            int diff = Math.abs(n2 + n1);
            if(diff < minDiff) {
                minDiff = diff;
                sol1 = left; sol2 = right;
            }

            if(diff == 0) return;
            if(n2 + n1 < 0) left++;
            else right--;
        }
    }
}
