import java.util.*;
import java.io.*;

public class _11399ATM {
    public static void main(String[] args) throws IOException {
        // 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numsStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(numsStr[i]);
        }
        Arrays.sort(arr);

        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                sum += arr[j];
            }
        }

        System.out.println(sum);
    }
}
