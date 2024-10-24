package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659PrefixSum4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String[] info = br.readLine().trim().split(" ");

        int n = Integer.parseInt(info[0]);
        int t = Integer.parseInt(info[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int i = 0, sum = 0;
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            arr[i++] = sum;
        }

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            try {
                sb.append(arr[b] - arr[a-1]).append("\n");
            } catch(ArrayIndexOutOfBoundsException e) {
                sb.append(arr[b]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
