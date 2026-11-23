package gold_3;

import java.io.*;
import java.util.*;

public class Main_14725 {

    static class Node {
        Map<String, Node> next = new TreeMap<>();
        boolean isEnd;
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node root = new Node();
        Node cur;
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            cur = root;

            for(int j=0; j<len; j++) {
                String food = st.nextToken();
                Node child = cur.next.get(food);
                if(child == null) {
                    child = new Node();
                    cur.next.put(food, child);
                }
                cur = child;
            }

            cur.isEnd = true;
        }

        search(root, 0);
        System.out.println(sb);
    }

    static void search(Node root, int depth) {
        if(root.isEnd) return;

        for(String key : root.next.keySet()) {
            for(int i=0; i<depth; i++) sb.append("--");
            sb.append(key).append("\n");

            search(root.next.get(key), depth+1);
        }
    }

}