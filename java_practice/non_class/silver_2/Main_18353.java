package silver_2;

import java.io.*;
import java.util.*;

public class Main_18353 {

    static int[] lis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int len = 0;
        lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int idx = binarySearch(0, len, x);

            lis[idx] = x;
            if(idx == len) len++;
        }

        System.out.println(n - len);
    }

    static int binarySearch(int lo, int hi, int x) {
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(x < lis[mid]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

}