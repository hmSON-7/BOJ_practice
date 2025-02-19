package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _11899_InsertParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!s.isEmpty() && (s.peek() == '(' && c == ')')) {
                s.pop(); continue;
            }
            s.push(c);
        }
        System.out.println(s.size());
    }
}
