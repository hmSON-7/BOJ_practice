package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16401_GivingOutSnacks {
    static int n, len, sum = 0, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(sum < n ? "0" : search());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[len];
        for(int i=0; i<len; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sum += x;
            if(x > max) max = x;
        }
    }

    private static int search() {
        int start = 1, end = max;
        while(start <= end) {
            int mid = (start + end) / 2, cnt = 0;
            for(int i=0; i<len; i++) {
                cnt += arr[i] / mid;
                if(cnt >= n) break;
            }
            if(cnt >= n) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }
}
