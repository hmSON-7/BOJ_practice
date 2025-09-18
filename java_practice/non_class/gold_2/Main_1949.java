package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1949 {
	
	// 마을 수
	static int n;
	// 각 마을의 인구 수
	static int[] arr; 
	// 트리 DP에 활용할 2차원 배열. dp[x][0] : 해당 마을을 우수 마을로 선정하지 않은 경우, dp[x][1] : 해당 마을을 우수 마을로 선정한 경우
	static int[][] dp;
	// 인접 리스트(양방향)
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n][2];
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		
		// 루트 노드는 따로 지정되지 않아 어느 곳을 잡아도 무관함
		preorder(0, -1);
		System.out.println(Math.max(dp[0][0], dp[0][1]));
	}
	
	// 후위 순회를 이용한 트리 DP
	static void preorder(int root, int parent) {
		List<Integer> childs = list.get(root);
		
		// 리프 노드인 경우
		if(childs.isEmpty()) {
			dp[root][0] = 0;
			dp[root][1] = arr[root];
			
			return;
		}
		
		// 자기 마을이 우수 마을로 선정된 경우와 그렇지 않은 경우
		// 각각의 경우 우수 마을로 지정된 마을 인구 수의 합을 기록
		int select = arr[root];
		int unsel = 0;
		for(int c : childs) {
			if(c == parent) continue;
			preorder(c, root);
			// 선정되지 않은 경우 : 인접 마을의 상태와 무관하므로 최대값을 가져옴
			unsel += Math.max(dp[c][0], dp[c][1]);
			
			// 선정된 경우 : 인접 마을은 모두 우수 마을이 아니어야 함
			select += dp[c][0];
		}
		
		dp[root][0] = unsel;
		dp[root][1] = select;
		
	}

}
