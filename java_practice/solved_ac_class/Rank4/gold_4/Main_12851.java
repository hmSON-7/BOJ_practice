package Rank4.gold_4;

import java.io.*;
import java.util.*;

public class Main_12851 {

    static int[] visited = new int[100_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(start == end) {
            System.out.println(0 + "\n" + 1);
            System.exit(0);
        }
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;

        int endCnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curIdx = cur[0], curTime = cur[1];
            int[] next = {curIdx-1, curIdx+1, curIdx*2};
            for(int x : next) {
                if(x > 100_000 || x < 0 || visited[x] < curTime+1) continue;
                visited[x] = curTime+1;
                if(x == end) {
                    endCnt++;
                    continue;
                }
                q.add(new int[]{x, curTime+1});
            }
        }
        System.out.println(visited[end] + "\n" + endCnt);
    }

}
