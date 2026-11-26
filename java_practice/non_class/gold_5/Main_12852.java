package gold_5;

import java.io.*;
import java.util.*;

public class Main_12852 {

    static int n;
    static int[] prev, next = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        prev = new int[n+1];
        StringBuilder sb = new StringBuilder();
        sb.append(bfs()).append("\n");

        while(n > 0) {
            sb.append(n).append(" ");
            n = prev[n];
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            next[0] = cur[0] + 1;
            next[1] = cur[0] * 2;
            next[2] = cur[0] * 3;

            for(int x : next) {
                if(x > n) break;
                if(prev[x] > 0) continue;

                prev[x] = cur[0];
                if(x == n) {
                    return cur[1] + 1;
                }

                q.add(new int[]{x, cur[1] + 1});
            }
        }

        return 0;
    }

}