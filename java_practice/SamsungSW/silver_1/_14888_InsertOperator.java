package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_InsertOperator {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int n, add, sub, mul, div;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());
        bt(1, arr[0]);
        System.out.println(max + "\n" + min);
    }

    static void bt(int idx, int curr) {
        if(idx == n) {
            max = Math.max(max, curr);
            min = Math.min(min, curr);
            return;
        }

        if(add > 0) {
            add--;
            bt(idx+1, curr + arr[idx]);
            add++;
        }
        if (sub > 0) {
            sub--;
            bt(idx + 1, curr - arr[idx]);
            sub++;
        }
        if (mul > 0) {
            mul--;
            bt(idx + 1, curr * arr[idx]);
            mul++;
        }
        if (div > 0) {
            div--;
            if (curr < 0) bt(idx + 1, -((-curr) / arr[idx]));
            else bt(idx + 1, curr / arr[idx]);
            div++;
        }
    }
}
