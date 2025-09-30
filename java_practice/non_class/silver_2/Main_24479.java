package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24479 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] time;
	static int cnt = 1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		
		visited = new boolean[v];
		time = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		for(int i=0; i<v; i++) {
			Collections.sort(list[i]);
		}
		
		visited[start] = true;
		dfs(start);
		for(int i=0; i<v; i++) {
			sb.append(time[i] + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int cur) {
		time[cur] = cnt++;
		
		for(int next : list[cur]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next);
		}
	}

}
