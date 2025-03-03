package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class _1334_NextPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length()/2; i++) {
            char c = str.charAt(i);
            s.push(c);
            sb.append(c);
        }
        if(str.length()%2 == 1) sb.append(str.charAt(str.length()/2));
        int mid = s.size();
        while(!s.isEmpty()) sb.append(s.pop());
        BigInteger exist = new BigInteger(str);
        BigInteger pal = new BigInteger(sb.toString());
        if(pal.compareTo(exist) <= 0) {
            sb = new StringBuilder();
            pal = pal.add(new BigInteger("10").pow(mid));
            String newStr = pal.toString();
            for(int i=0; i<newStr.length()/2; i++) {
                char c = newStr.charAt(i);
                s.push(c);
                sb.append(c);
            }
            if(newStr.length()%2 == 1) sb.append(newStr.charAt(newStr.length()/2));
            while(!s.isEmpty()) sb.append(s.pop());
            pal = new BigInteger(sb.toString());
        }
        System.out.println(pal);
    }
}
