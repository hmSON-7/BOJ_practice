package platinum_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6549_LargestRectangle_in_Histogram {
    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        while(true) {
            read();
            if(n == 0) break;
            sb.append(solve(0, n-1)).append("\n");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if(n == 0) return;
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static long solve(int start, int end) {
        if(start == end) return arr[start];
        int mid = (start + end) / 2;
        long halfRect = Math.max(solve(start, mid), solve(mid + 1, end));

        int left = mid, right = mid + 1;
        int minHeight = Math.min(arr[left], arr[right]);
        long middleRect = (long)minHeight * 2;
        while(left > start && right < end) {
            if(arr[left-1] >= arr[right+1]) {
                minHeight = Math.min(minHeight, arr[--left]);
            } else {
                minHeight = Math.min(minHeight, arr[++right]);
            }
            middleRect = Math.max(middleRect, (long)minHeight * (right - left + 1));
        }
        while(left > start) {
            minHeight = Math.min(minHeight, arr[--left]);
            middleRect = Math.max(middleRect, (long)minHeight * (right - left + 1));
        }
        while(right < end) {
            minHeight = Math.min(minHeight, arr[++right]);
            middleRect = Math.max(middleRect, (long)minHeight * (right - left + 1));
        }

        return Math.max(halfRect, middleRect);
    }
}
