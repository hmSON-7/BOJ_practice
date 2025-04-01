package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18511_ConfiguringLargeNumbers {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        config(n, arr, 0);
        System.out.println(res);
    }

    static void config(int n, int[] arr, int total) {
        if(total > n) return;
        if(total > res) res = total;
        for(int i=arr.length - 1; i>=0; i--) {
            config(n, arr, total * 10 + arr[i]);
        }
    }
}
