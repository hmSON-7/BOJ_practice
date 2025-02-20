package silver_2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406_Editor {
    public static void main(String[] args) throws IOException {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    String word = st.nextToken();
                    left.push(word.charAt(0));
                    break;
                default: break;
            }
        }
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        while(!right.isEmpty()) {
            bw.write(right.pop());
        }
        bw.flush();
    }
}
