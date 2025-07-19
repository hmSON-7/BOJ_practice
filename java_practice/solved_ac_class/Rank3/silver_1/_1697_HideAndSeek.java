package Rank3.silver_1;

import java.io.*;
import java.util.*;

public class _1697_HideAndSeek {
    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 100000;
    static Queue<Integer> q = new LinkedList<>();
    static int[] visited = new int[MAX_VALUE * 2 + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        q.add(start);
        int current = 0;
        while(!q.isEmpty()) {
            current = q.poll();
            if(current == goal) break;

            int[] target = new int[]{current - 1, current + 1, current * 2};
            for(int t : target) {
                if(t < MIN_VALUE || t >= MAX_VALUE * 2) continue;
                if(visited[t] > 0) continue;
                visited[t] = visited[current] + 1;
                q.add(t);
            }
        }

        System.out.println(visited[current]);
    }
}
