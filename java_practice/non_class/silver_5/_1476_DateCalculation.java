package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1476_DateCalculation {
    static final int MAX_E = 15, MAX_S = 28, MAX_M = 19;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 1, cntE  = 1, cntS = 1, cntM = 1;
        while (cntE != e || cntS != s || cntM != m) {
            cnt++;
            cntE = cntE == MAX_E ? 1 : cntE + 1;
            cntS = cntS == MAX_S ? 1 : cntS + 1;
            cntM = cntM == MAX_M ? 1 : cntM + 1;
        }
        System.out.println(cnt);
    }
}
