import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] list;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][2];
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		postorder(0, -1);
		System.out.println(Math.min(dp[0][0], dp[0][1]));
	}
	
	static void postorder(int root, int parent) {
		List<Integer> childs = list[root];
		if(childs.size() == 0) {
			dp[root][0] = 0;
			dp[root][1] = 1;
			return;
		}
		
		int sel = 1, unsel = 0;
		for(int c : childs) {
			if(c == parent) continue;
			postorder(c, root);
			sel += Math.min(dp[c][0], dp[c][1]);
			unsel += dp[c][1];
		}
		
		dp[root][0] = unsel;
		dp[root][1] = sel;
	}
	
}