package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11728_MergingArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int idx1 = 0, idx2 = 0;
        StringBuilder sb = new StringBuilder();
        while(idx1 < n1 && idx2 < n2) {
            int x1 = arr1[idx1], x2 = arr2[idx2];
            if(x1 <= x2) {
                sb.append(x1).append(" "); idx1++;
            } else {
                sb.append(x2).append(" "); idx2++;
            }
        }
        while(idx1 < n1) sb.append(arr1[idx1++]).append(" ");
        while(idx2 < n2) sb.append(arr2[idx2++]).append(" ");
        System.out.println(sb);
    }
}
