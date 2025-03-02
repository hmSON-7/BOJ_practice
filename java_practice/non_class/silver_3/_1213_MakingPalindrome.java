package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1213_MakingPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] cnt = new int[26];
        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            cnt[c-'A']++;
        }
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int oddCnt = 0; char oddChar = ' ';
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i] == 0) continue;
            char c = (char)(i + 'A');
            if(cnt[i]%2 == 1) {
                oddCnt++;
                oddChar = c;
                if(oddCnt >= 2) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
            for(int j=0; j<cnt[i]/2; j++) {
                s.push(c);
                sb.append(c);
            }
        }
        if(oddChar != ' ') sb.append(oddChar);
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
}
