package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3020_Firefly {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) / 2;
        int h = Integer.parseInt(st.nextToken());
        int[] diff = new int[h];
        for(int i=0; i<n; i++) {
            int u = Integer.parseInt(br.readLine());
            int d = Integer.parseInt(br.readLine());
            diff[0] += 1;
            diff[u] -= 1;
            diff[h-d] += 1;
        }
        int min = Integer.MAX_VALUE, cnt = 0, curr = 0;
        for(int i=0; i<h; i++) {
            curr += diff[i];
            if(curr < min) {
                min = curr;
                cnt = 1;
            } else if(curr == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
