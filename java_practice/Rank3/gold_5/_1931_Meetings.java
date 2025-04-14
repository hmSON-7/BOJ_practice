package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931_Meetings {
    private static int compareMeetings(int[] a, int[] b) {
        return a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
    }
    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        int[][] meets = new int[times][2];
        for(int i=0; i<times; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meets[i][0] = Integer.parseInt(st.nextToken());
            meets[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meets, _1931_Meetings::compareMeetings);
        int end = meets[0][1], cnt = 1;
        for(int i=1; i<meets.length; i++) {
            if(meets[i][0] < end) continue;

            cnt++;
            end = meets[i][1];
        }

        System.out.println(cnt);
    }
}
