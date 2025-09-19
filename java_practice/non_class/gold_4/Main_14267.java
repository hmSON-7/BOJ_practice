package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14267 {
	
	static int n;
	static int[] arr, dp;
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		dp = new int[n];
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int upper = Integer.parseInt(st.nextToken()) - 1;
			if(upper >= 0) {
				list.get(i).add(upper);
				list.get(upper).add(i);
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			
			arr[idx] += value;
		}
		
		preorder(0, -1);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(dp[i]+ " ");
		}
		
		System.out.println(sb);
		
	}
	
	static void preorder(int root, int parent) {
		if(parent >= 0) {
			dp[root] = dp[parent] + arr[root];
		}
		
		List<Integer> childs = list.get(root);
		if(childs.isEmpty()) return;
		
		for(int c : childs) {
			if(c == parent) continue;
			preorder(c, root);
		}
	}

}
