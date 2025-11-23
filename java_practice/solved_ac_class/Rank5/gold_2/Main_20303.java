package Rank5.gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20303 {

	static int n, k;
	static int[] root, candy, friends;
	
	public static void main(String[] args) throws Exception {
		init();
		int[] dp = new int[k];
		for(int i=0; i<n; i++) {
			if(root[i] != i || friends[i] >= k) continue;
			
			for(int j=k-1; j>=friends[i]; j--) {
				dp[j] = Math.max(dp[j-friends[i]] + candy[i], dp[j]);
			}
		}
		
		System.out.println(dp[k-1]);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		root = new int[n];
		candy = new int[n];
		friends = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			root[i] = i;
			candy[i] = Integer.parseInt(st.nextToken());
			friends[i] = 1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			union(c1, c2);
		}
	}
	
	static int find(int x) {
		if(root[x] == x) return x;
		return root[x] = find(root[x]);
	}
	
	static void union(int a, int b) {
		int ra = find(a), rb = find(b);
		if(ra == rb) return;
		
		if(friends[ra] >= friends[rb]) {
			root[rb] = ra;
			friends[ra] += friends[rb];
			candy[ra] += candy[rb];
		}
		else {
			root[ra] = rb;
			friends[rb] += friends[ra];
			candy[rb] += candy[ra];
		}
	}
	
}
