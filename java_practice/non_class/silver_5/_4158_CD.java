package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4158_CD {
    static int n, m;
    static int[] cdArr1, cdArr2;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        while(true) {
            read();
            if(n == 0 && m == 0) break;
            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if(n == 0 && m == 0) return;
        cdArr1 = new int[n];
        cdArr2 = new int[m];
        for(int i=0; i<n; i++) {
            cdArr1[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<m; i++) {
            cdArr2[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cdArr1);
        Arrays.sort(cdArr2);
    }

    private static int solve() {
        int cnt = 0, idx1 = 0, idx2 = 0;
        while(idx1 < n && idx2 < m) {
            int cd1 = cdArr1[idx1], cd2 = cdArr2[idx2];
            if(cd1 == cd2) {
                cnt++; idx1++; idx2++;
            }
            else if(cd1 < cd2) idx1++;
            else idx2++;
        }
        return cnt;
    }
}
