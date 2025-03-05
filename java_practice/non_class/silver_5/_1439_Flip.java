package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439_Flip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int[] cnt = new int[2];
        char cur = ' ';
        for(int i=0; i<str.length; i++) {
            if(i==0) {
                cur = str[i];
                continue;
            }
            if(str[i] == cur) continue;
            cnt[cur - '0']++;
            cur = str[i];
        }
        cnt[cur - '0']++;
        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}
