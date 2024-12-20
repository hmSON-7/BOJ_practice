package gold_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int edge, cost;
    public Node(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }
}

public class _1753_ShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] info = br.readLine().trim().split(" ");
        int v = Integer.parseInt(info[0]);
        int e = Integer.parseInt(info[1]);
        int start = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[v+1];
        int[] totalCost = new int[v+1];
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
            totalCost[i] = i == start ? 0 : Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++) {
            String[] nodeInfo = br.readLine().trim().split(" ");
            int from = Integer.parseInt(nodeInfo[0]);
            int to = Integer.parseInt(nodeInfo[1]);
            int cost = Integer.parseInt(nodeInfo[2]);
            graph.get(from).add(new Node(to, cost));
        }

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.add(new Node(start, 0));
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(visited[current.edge]) continue;
            visited[current.edge] = true;
            totalCost[current.edge] = current.cost;
            List<Node> next = graph.get(current.edge);

            for(Node n : next) {
                if(visited[n.edge]) continue;
                int newCost = current.cost + n.cost;
                q.add(new Node(n.edge, newCost));
            }
        }

        for(int i=1; i<totalCost.length; i++) {
            sb.append(totalCost[i] == Integer.MAX_VALUE ? "INF" : totalCost[i]);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
