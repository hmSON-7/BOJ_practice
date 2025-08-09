package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1759 {

    static int n, k, bit;
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    static char[] chars;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        init(); bt(0, 0, 0, 0);
        System.out.println(sb);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        chars = new char[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        bit = 0;
    }

    public static void bt(int start, int cnt, int vowelCnt, int consCnt) {
        if(cnt == n) {
            if(vowelCnt >= 1 && consCnt >= 2) {
                for(int i=0; i<k; i++) {
                    if((bit & (1 << i)) != 0) sb.append(chars[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=start; i<=k-n+cnt; i++) {
            bit = bit | (1 << i);
            if(vowels.contains(chars[i])) {
                bt(i+1, cnt+1, vowelCnt+1, consCnt);
            } else {
                bt(i+1, cnt+1, vowelCnt, consCnt+1);
            }
            bit  = bit & ~(1 << i);
        }
    }

}
