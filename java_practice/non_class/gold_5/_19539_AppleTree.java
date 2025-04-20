package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19539_AppleTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt1 = 0, cnt2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            cnt2 += x/2; cnt1 += x%2;
        }
        boolean flag = true;
        if(cnt1 > cnt2) flag = false;
        else if((cnt2 - cnt1) % 3 != 0) flag = false;
        System.out.println(flag ? "YES" : "NO");
    }
}
