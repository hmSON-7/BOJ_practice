package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1135 {
	
	static int n;
	static int[] dp;
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x != -1) list.get(x).add(i);
		}
		
		postorder(0);
		System.out.println(dp[0]);
	}
	
	public static void postorder(int root) {
		List<Integer> childs = list.get(root);
		
		if(childs.isEmpty()) return;
		
		for(int c : childs) postorder(c);
		childs.sort((a, b) -> Integer.compare(dp[b], dp[a]));
		int max = 0, time = 1;
		for(int c : childs) {
			int elapsed = dp[c] + time;
			if(elapsed > max) max = elapsed;
			time++;
		}
		dp[root] = max;
	}

}
