package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352 {
	
	static int v, e, d, start;
	static List<Integer>[] list;
	static boolean[] visited;
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken()) - 1;
		
		visited = new boolean[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = (new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			list[from].add(to);
		}
		
		bfs();
		if(result.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for(int target : result) {
			sb.append((target+1) + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int id = cur[0], dist = cur[1];
			
			for(int next : list[id]) {
				if(visited[next]) continue;
				visited[next] = true;
				
				if(dist + 1 == d) result.add(next);
				else q.add(new int[] {next, dist+1});
			}
		}
	}

}
