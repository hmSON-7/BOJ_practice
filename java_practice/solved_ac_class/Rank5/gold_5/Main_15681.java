package Rank5.gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15681 {
	
	static int v, rootNum, query;
	static int[] dp;
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		rootNum = Integer.parseInt(st.nextToken()) - 1;
		query = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<v; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<v-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		dp = new int[v];
		Arrays.fill(dp, 1);
		postorder(rootNum, -1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<query; i++) {
			int target = Integer.parseInt( br.readLine()) - 1;
			sb.append(dp[target] + "\n");
		}
		System.out.println(sb);
	}
	
	static void postorder(int root, int parent) {
		List<Integer> childs = graph.get(root);
		
		if(childs.isEmpty()) return;
		
		for(int c : childs) {
			if(c == parent) continue;
			postorder(c, root);
			dp[root] += dp[c];
		}
	}

}
