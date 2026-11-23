package platinum_4;

import java.io.*;
import java.util.*;

public class Main_5670 {

    static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isEnd = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        String[] words;
        char[] str;

        while((input = br.readLine()) != null && !(input.isEmpty())) {
            int n = Integer.parseInt(input);
            words = new String[n];
            Node root = new Node();
            Node cur;

            for(int i=0; i<n; i++) {
                words[i] = br.readLine();
                str = words[i].toCharArray();
                cur = root;

                for(char ch : str) {
                    Node child = cur.next.get(ch);
                    if(child == null) {
                        child = new Node();
                        cur.next.put(ch, child);
                    }
                    cur = child;
                }
                cur.isEnd = true;
            }

            int cnt = 0;
            for(String word : words) {
                str = word.toCharArray();
                cur = root.next.get(str[0]);
                cnt++;

                for(int i=1; i<str.length; i++) {
                    if(cur.next.size() > 1 || cur.isEnd) cnt++;
                    cur = cur.next.get(str[i]);
                }
            }

            sb.append(String.format("%.2f", (double)cnt / n)).append("\n");
        }

        System.out.print(sb);
    }

}