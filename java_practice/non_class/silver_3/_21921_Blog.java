package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921_Blog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int window = 0, sum = 0, cnt = 1;
        for(int i=0; i<x; i++) {
            window += arr[i];
        }
        sum = window;
        for(int i=x; i<n; i++) {
            window += arr[i] - arr[i-x];
            if(window == sum) cnt++;
            else if(window > sum) {
                sum = window;
                cnt = 1;
            }
        }
        if(sum == 0) System.out.println("SAD");
        else {
            System.out.println(sum + "\n" + cnt);
        }
    }
}
