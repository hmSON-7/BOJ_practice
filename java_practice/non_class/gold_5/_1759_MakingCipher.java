package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759_MakingCipher {
    static int len, n;
    static char[] arr, vowels = {'a', 'e', 'i', 'o', 'u'}, cipher;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        read(); solve(0, 0, 0 ,0);
        System.out.println(sb);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        cipher = new char[len];
        arr = new char[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
    }

    private static void solve(int idx, int cnt, int vowelCnt, int consonantCnt) {
        if(cnt == len) {
            if(vowelCnt >= 1 && consonantCnt >= 2) {
                for(int i=0; i<cnt; i++) {
                    sb.append(cipher[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=idx; i<n; i++) {
            char c = arr[i];
            boolean vowelFound = false;
            for(char v : vowels) {
                if(c == v) {
                    vowelCnt++;
                    vowelFound = true;
                    break;
                }
            }
            if(!vowelFound) consonantCnt++;
            cipher[cnt] = c;
            solve(i+1, cnt+1, vowelCnt, consonantCnt);
            if(vowelFound) vowelCnt--;
            else consonantCnt--;
        }
    }
}
