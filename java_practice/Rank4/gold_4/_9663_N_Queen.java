package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_N_Queen {
    public static int n, cnt = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        bt(0);
        System.out.println(cnt);
    }

    public static void bt(int idx) {
        if(idx == n) {
            cnt++; return;
        }
        for(int i=0; i<n; i++) {
            arr[idx] = i;
            if(check(idx)) bt(idx + 1);
        }
    }

    public static boolean check(int x) {
        for(int i=0; i<x; i++) {
            if(arr[x] == arr[i]) return false;
            else if(Math.abs(x-i) == Math.abs(arr[x] - arr[i])) return false;
        }
        return true;
    }
}
