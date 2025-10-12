package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {
	
	static final int INF = 200_000_000;
	static int v, pa, pb, distPTP = INF, total;
	static int[] dist;
	static List<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int id, cost;
		
		public Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		int sumA = 0, sumB = 0;
		dijkstra(0);
		if(dist[pa] == INF || dist[pb] == INF) {
			System.out.println(-1);
			return;
		}
		sumA += dist[pa]; sumB += dist[pb];
		
		dijkstra(v-1);
		if(dist[pa] == INF || dist[pb] == INF) {
			System.out.println(-1);
			return;
		}
		sumA += dist[pb]; sumB += dist[pa];
		
		dijkstra(pa);
		sumA += dist[pb]; sumB += dist[pb];
		
		System.out.println(Math.min(sumA,  sumB));
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dist = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			list[v1].add(new Node(v2, cost));
			list[v2].add(new Node(v1, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		pa = Integer.parseInt(st.nextToken()) - 1;
		pb = Integer.parseInt(st.nextToken()) - 1;
	}
	
	static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(dist[cur.id] < cur.cost) continue;
			
			for(Node next : list[cur.id]) {
				int newCost = cur.cost + next.cost;
				if(dist[next.id] <= newCost) continue;
				q.add(new Node(next.id, newCost));
				dist[next.id] = newCost;
			}
		}
	}

}
