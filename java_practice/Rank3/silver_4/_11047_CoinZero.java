package silver_4;

import java.util.*;
import java.io.*;

public class _11047_CoinZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int kind = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] arr = new int[kind];
        for(int i=0; i<kind; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i=kind-1; i>=0; i--) {
            if(arr[i] > total) continue;
            cnt += total / arr[i];
            total %= arr[i];
        }
        System.out.println(cnt);
    }
}
