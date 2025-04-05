package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2004_CountOfZero_InCombination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt5 = cntMulti(n, 5) - cntMulti(n-m, 5) - cntMulti(m, 5);
        int cnt2 = cntMulti(n, 2) - cntMulti(n-m, 2) - cntMulti(m, 2);
        System.out.println(Math.min(cnt5, cnt2));
    }

    static int cntMulti(int n, int unit) {
        int cnt = 0;
        while(n >= unit) {
            cnt += n / unit;
            n /= unit;
        }
        return cnt;
    }
}
