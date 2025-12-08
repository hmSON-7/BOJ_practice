package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1240 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, k;
	static List<Node>[] tree;
	
	static class Node {
		int to, cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[n];
		for(int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			tree[v1].add(new Node(v2, cost));
			tree[v2].add(new Node(v1, cost));
		}
	}
	
	static int bfs(int s, int e) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(s, 0));
		
		boolean[] visited = new boolean[n];
		visited[s] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(Node next : tree[cur.to]) {
				if(visited[next.to]) continue;
				
				if(next.to == e) return cur.cost + next.cost;
				q.add(new Node(next.to, cur.cost + next.cost));
				visited[next.to] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append((bfs(v1, v2)) + "\n");
		}
		
		System.out.println(sb);
	}

}
