package silver_2;

import java.io.*;
import java.util.*;

public class _1260_DFSandBFS {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    static void DFS(int start) {
        check[start] = true;
        sb.append(start + " ");

        for(int i=0; i<=node; i++) {
            if(arr[start][i] == 1 && !check[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for(int i=1; i<=node; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().trim().split(" ");
        node = Integer.parseInt(info[0]);
        line = Integer.parseInt(info[1]);
        start = Integer.parseInt(info[2]);

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        while(line-- > 0) {
            String[] link = br.readLine().trim().split(" ");
            int from = Integer.parseInt(link[0]);
            int to = Integer.parseInt(link[1]);

            arr[from][to] = arr[to][from] = 1;
        }

        DFS(start);
        sb.append("\n");

        check = new boolean[node+1];
        BFS(start);
        System.out.println(sb);

        br.close();
    }
}
