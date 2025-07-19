package Rank3.silver_4;

import java.util.*;
import java.io.*;

public class _11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = arr[0];
        for(int i=1; i<n; i++) {
            arr[i] += arr[i-1];
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
