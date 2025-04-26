package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1138_StandingInALine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int left = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(arr[j] > 0) continue;
                if(cnt == left) {
                    arr[j] = i;
                    break;
                }
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
