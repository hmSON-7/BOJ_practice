package Rank3.gold_4;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662_DualPriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")) {
                    int key = Integer.parseInt(st.nextToken());
                    map.put(key, map.getOrDefault(key, 0) + 1);
                } else {
                    int cmd = Integer.parseInt(st.nextToken());
                    if(map.isEmpty()) continue;
                    int key = cmd == 1 ? map.lastKey() : map.firstKey();
                    map.put(key, map.get(key) - 1);
                    if(map.get(key) == 0) map.remove(key);
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }
            int maxKey = map.lastKey();
            int minKey = map.firstKey();
            sb.append(maxKey).append(" ").append(minKey).append("\n");
        }
        System.out.println(sb);
    }
}
