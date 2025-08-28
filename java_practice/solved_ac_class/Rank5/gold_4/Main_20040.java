package Rank5.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040 {
	
	static int v, e, t = 0;
	static int[] arr;
	static Edge[] edges;
	
	static class Edge {
		int from, to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		for(int i=0; i<e; i++) {
			Edge edge = edges[i];
			boolean flag = union(edge.from, edge.to);
			if(!flag) {
				t = i+1;
				break;
			}
		}
		
		System.out.println(t);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		arr = new int[v];
		for(int i=0; i<v; i++) {
			arr[i] = i;
		}
		edges = new Edge[e];
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(v1, v2);
		}
	}
	
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
	static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra == rb) return false;
		if(ra > rb) arr[ra] = rb;
		else arr[rb] = ra;
		return true;
	}

}
