package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11582_Chicken_TOP_N {
    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        int[] res = sort(1, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
    }

    private static int[] sort(int members, int start) {
        int part = n / members;
        if(members == k) {
            int[] sorted = new int[part];
            System.arraycopy(arr, start, sorted, 0, part);
            Arrays.sort(sorted);
            return sorted;
        }
        int[] res1 = sort(members * 2, start);
        int[] res2 = sort(members * 2, start + (part/2));
        int[] total = new int[part];
        System.arraycopy(res1, 0, total, 0, res1.length);
        System.arraycopy(res2, 0, total, res1.length, res2.length);
        return total;
    }
}
