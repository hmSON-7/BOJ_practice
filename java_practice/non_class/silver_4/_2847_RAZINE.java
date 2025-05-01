package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2847_RAZINE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int prev = arr[n-1], sum = 0;
        for(int i=n-2; i>=0; i--) {
            int x = arr[i];
            if(x >= prev) {
                prev--; sum += x - prev;
            } else prev = x;
        }
        System.out.println(sum);
    }
}
