package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1946_Freshman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                arr[x] = Integer.parseInt(st.nextToken());
            }
            int min = arr[1], cnt = 0;
            for(int i=1; i<=n; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                    cnt++;
                    if(min == 1) break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
