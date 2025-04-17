package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2143_SumOfTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += arr1[j];
                map.put(sum, map.getOrDefault(sum, 0L) + 1);
            }
        }
        long cnt = 0;
        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=i; j<m; j++) {
                sum += arr2[j];
                Long cnt1 = map.get(t - sum);
                if(cnt1 != null) cnt += cnt1;
            }
        }
        System.out.println(cnt);
    }
}
