package Rank5.gold_3;

import java.io.*;
import java.util.*;

public class Main_2252 {

	static int v;
	static int[] prev;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		prev = new int[v];
		graph = new ArrayList[v];
		for(int i=0; i<v; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			prev[to]++;
			graph[from].add(to);
		}
	}

	static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();

		for(int i=0; i<v; i++) {
			if(prev[i] > 0) continue;
			q.add(i);
		}

		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+1).append(" ");

			for(int next : graph[cur]) {
				prev[next]--;
				if(prev[next] > 0) continue;

				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		topologicalSort();

		System.out.println(sb);
	}
	
}