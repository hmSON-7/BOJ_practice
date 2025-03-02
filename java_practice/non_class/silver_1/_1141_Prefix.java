package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1141_Prefix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        for(int i=0; i<n; i++) {
            strArr[i] = br.readLine();
        }
        Arrays.sort(strArr, (a, b) -> b.length() - a.length());
        int cnt = 0;
        for(int i=0; i<n; i++) {
            String s = strArr[i];
            boolean flag = false;
            for(int j=0; j<i; j++) {
                if(strArr[j].startsWith(s)) {
                    flag = true; break;
                }
            }
            if(!flag) cnt++;
        }
        System.out.println(cnt);
    }
}
