package silver_1;

import java.io.*;
import java.util.*;

public class Main_14426 {

    static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isEnd = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Node root = new Node();
        Node cur;

        for(int i=0; i<n; i++) {
            char[] str = br.readLine().toCharArray();
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
        for(int i=0; i<q; i++) {
            char[] queryStr = br.readLine().toCharArray();
            cur = root;

            boolean flag = true;
            for(char ch : queryStr) {
                cur = cur.next.get(ch);
                if(cur == null) {
                    flag = false;
                    break;
                }
            }

            if(flag) cnt++;
        }

        System.out.println(cnt);
    }

}