package Rank3.silver_2;

import java.io.*;
import java.util.*;

public class _11724_ConnectedComponent {
    static int cntGraph = 0;
    static int node;
    static int line;
    static Queue<Integer> q = new LinkedList<>();
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        node = Integer.parseInt(info[0]);
        line = Integer.parseInt(info[1]);

        for(int i=1; i<=node; i++) {
            graph.put(i, new ArrayList<>());
        }

        while(line-->0) {
            String[] link = br.readLine().trim().split(" ");
            int x = Integer.parseInt(link[0]);
            int y = Integer.parseInt(link[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        while(!graph.isEmpty()) {
            bfs();
            cntGraph++;
        }

        System.out.println(cntGraph);
    }

    static void bfs() {
        int startNode = graph.keySet().iterator().next();

        q.add(startNode);
        while (!q.isEmpty()) {
            int curNode = q.poll();

            if (graph.containsKey(curNode)) {
                List<Integer> neighbors = graph.get(curNode);
                graph.remove(curNode);

                for (int neighbor : neighbors) {
                    if (graph.containsKey(neighbor)) {
                        q.add(neighbor);
                    }
                }
            }
        }
    }
}
