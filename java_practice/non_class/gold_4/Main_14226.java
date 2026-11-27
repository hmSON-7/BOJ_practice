package gold_4;

import java.io.*;
import java.util.*;

public class Main_14226 {

    static final int MAX = 2000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1, 1});

        boolean[][] visited = new boolean[MAX][MAX];
        visited[1][1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] != cur[1] && !visited[cur[0]][cur[0]]) {
                visited[cur[0]][cur[0]] = true;
                q.add(new int[]{cur[0], cur[0], cur[2] + 1});
            }
            if(cur[0] < n) {
                int newLen = cur[0] + cur[1];
                if(newLen == n) {
                    System.out.println(cur[2] + 1);
                    return;
                }

                if(!visited[newLen][cur[1]]) {
                    visited[newLen][cur[1]] = true;
                    q.add(new int[]{newLen, cur[1], cur[2] + 1});
                }
            }
            if(cur[0] > 1) {
                int newLen = cur[0] - 1;
                if(newLen == n) {
                    System.out.println(cur[2] + 1);
                    return;
                }

                if(!visited[newLen][cur[1]]) {
                    visited[newLen][cur[1]] = true;
                    q.add(new int[]{newLen, cur[1], cur[2] + 1});
                }
            }
        }
    }

}