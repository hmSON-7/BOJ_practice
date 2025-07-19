package Rank3.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1389_KevinBacon {
    static boolean[][] relation;
    static int n;
    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        n = Integer.parseInt(info[0]);
        int re = Integer.parseInt(info[1]);
        relation = new boolean[n][n];

        for(int i=0; i<re; i++) {
            String[] link = br.readLine().trim().split(" ");
            relation[Integer.parseInt(link[0]) - 1][Integer.parseInt(link[1]) - 1] = true;
            relation[Integer.parseInt(link[1]) - 1][Integer.parseInt(link[0]) - 1] = true;
        }

        int minSum = Integer.MAX_VALUE;
        int resultPerson = -1;
        for (int i = 0; i < n; i++) {
            int sum = findRelation(i);
            if (sum < minSum) {
                minSum = sum;
                resultPerson = i;
            }
        }

        System.out.println(resultPerson + 1);
    }

    static int findRelation(int start) {
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        int total = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int person = current[0];
            int depth = current[1];

            total += depth;

            for (int i = 0; i < n; i++) {
                if (relation[person][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(new int[]{i, depth + 1});
                }
            }
        }

        return total;
    }
}
