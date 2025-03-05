package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10610_Thirty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int[] cnt = new int[10];
        int sum = 0;
        for(char c : str) {
            int d = c - '0';
            cnt[d]++;
            sum += d;
        }
        if(cnt[0] == 0 || sum%3 != 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int d=9; d>=0; d--) {
            while (cnt[d] --> 0) {
                sb.append(d);
            }
        }
        System.out.println(sb);
    }
}
