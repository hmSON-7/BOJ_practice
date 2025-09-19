package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12784 {
	
	static int v, e;
	static int[] arr, dp;
	static List<List<Node>> list = new ArrayList<>();
	
	static class Node {
		int id, cost;

		public Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(tc --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			if(v == 1) {
				sb.append(0 + "\n");
				continue;
			}
			
			arr = new int[v];
			dp = new int[v];
			for(int i=0; i<v; i++) {
				list.add(new ArrayList<>());
				arr[i] = Integer.MAX_VALUE;
			}
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken())-1;
				int v2 = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				
				list.get(v1).add(new Node(v2, cost));
				list.get(v2).add(new Node(v1, cost));
			}
			
			postorder(0, -1);
			
			sb.append(dp[0] + "\n");
			list.clear();
		}
		
		System.out.println(sb);
	}
	
	static void postorder(int root, int parent) {
		List<Node> childs = list.get(root);
		
		int sum = 0;
		for(Node c : childs) {
			if(c.id == parent) continue;
			arr[c.id] = c.cost; 
			postorder(c.id, root);
			sum += dp[c.id];
		}
		
		if(sum == 0) {
			dp[root] = arr[root];
			return;
		}
		
		dp[root] = Math.min(sum, arr[root]);
	}
	
}
