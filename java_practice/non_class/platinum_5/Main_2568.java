package platinum_5;

import java.io.*;
import java.util.*;

public class Main_2568 {

    static final int MAX = 500_001;
    static int[][] lis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] lines = new int[MAX];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            lines[a] = Integer.parseInt(st.nextToken());
        }

        int[] prev = new int[MAX];
        int len = 0;
        lis = new int[n][2];

        for(int i=1; i<MAX; i++) {
            if(lines[i] == 0) continue;
            int idx = binarySearch(0, len, lines[i]);

            prev[i] = idx > 0 ? lis[idx-1][0] : -1;

            lis[idx][0] = i;
            lis[idx][1] = lines[i];
            if(idx == len) len++;
        }

        int ptr = lis[len-1][0];
        boolean[] nonCrossed = new boolean[MAX];

        while(ptr != -1) {
            nonCrossed[ptr] = true;
            ptr = prev[ptr];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n - len).append("\n");

        for(int i=1; i<MAX; i++) {
            if(lines[i] == 0) continue;
            if(!nonCrossed[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static int binarySearch(int lo, int hi, int x) {
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(x > lis[mid][1]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

}