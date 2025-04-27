package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1343_Polyomino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'X') {
                cnt++; continue;
            }
            if(cnt % 2 != 0) {
                cnt = -1; break;
            }
            while(cnt >= 4) {
                sb.append("AAAA"); cnt -= 4;
            }
            if(cnt == 2) {
                sb.append("BB"); cnt = 0;
            }
            sb.append('.');
        }
        if(cnt % 2 != 0) cnt = -1;
        while(cnt >= 4) {
            sb.append("AAAA"); cnt -= 4;
        }
        if(cnt == 2) {
            sb.append("BB"); cnt = 0;
        }
        System.out.println(cnt == -1 ? cnt : sb);
    }
}
