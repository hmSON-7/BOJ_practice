package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2447_AsteriskPattern_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] pattern = makePattern(n);
        for(String line : pattern) {
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }

    static String[] makePattern(int n) {
        if(n == 1) return new String[] {"*"};
        String[] prev = makePattern(n/3);
        String[] pattern = new String[n];
        int idx = 0;
        for(int i=0; i<n/3; i++) {
            pattern[idx++] = prev[i] + prev[i] + prev[i];
        }

        StringBuilder sbSpace = new StringBuilder();
        for (int i = 0; i < n / 3; i++) {
            sbSpace.append(" ");
        }
        String space = sbSpace.toString();

        for(int i=0; i<n/3; i++) {
            pattern[idx++] = prev[i] + space + prev[i];
        }
        for(int i=0; i<n/3; i++) {
            pattern[idx++] = prev[i] + prev[i] + prev[i];
        }
        return pattern;
    }
}
