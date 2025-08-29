package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1967 {
	
	static int n, edge1, max;
	static boolean[] visited;
	static List<List<int[]>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		init();
		max = 0;
		visited[0] = true; 
		dfs(0, 0);
		visited[0] = false;
		visited[edge1] = true;
		dfs(edge1, 0);
		System.out.println(max);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[n];
		StringTokenizer st;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			list.get(a).add(new int[] {b, cost});
			list.get(b).add(new int[] {a, cost});
		}
	}
	
	static void dfs(int start, int cnt) {
		if(cnt > max) {
			max = cnt;
			edge1 = start;
		}
		
		for(int[] nextNode : list.get(start)) {
			int next = nextNode[0];
			int cost = nextNode[1];
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next, cnt + cost);
			visited[next] = false; 
		}
	}

}
