package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17425_SumOfFactor {
    static final int MAX = 1000001;
    static long[] gx = new long[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sieve();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(gx[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void sieve() {
        for(int i=1; i<MAX; i++) {
            int x = 1;
            gx[i] += gx[i-1];
            while(i*x < MAX) {
                gx[i * x++] += i;
            }
        }
    }
}
