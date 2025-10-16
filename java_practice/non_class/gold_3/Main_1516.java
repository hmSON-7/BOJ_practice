package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1516 {
	
	static int v;
	static int[] times, prev;
	static List<Integer>[] list;
	
	static class Node implements Comparable<Node>{
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
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		times = new int[v];
		prev = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int req = Integer.parseInt(st.nextToken()) - 1;
				if(req == -2) break;
				
				list[req].add(i);
				prev[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i=0; i<v; i++) {
			if(prev[i] == 0) q.add(new Node(i, times[i]));
		}
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			times[cur.id] = cur.cost;
			
			for(int next : list[cur.id]) {
				prev[next]--;
				if(prev[next] > 0) continue;
				
				q.add(new Node(next, cur.cost + times[next]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<v; i++) {
			sb.append(times[i] + "\n");
		}
		System.out.println(sb);
	}

}
