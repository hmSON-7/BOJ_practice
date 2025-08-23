package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567 {
	
	static int n, con;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] prevCnt, term;
	
	public static void main(String[] args) throws Exception {
		init(); topologicalSort();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(term[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		con = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		prevCnt = new int[n];
		term = new int[n];
		
		for(int i=0; i<con; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken()) - 1;
			int after = Integer.parseInt(st.nextToken()) - 1;
			list.get(before).add(after);
			prevCnt[after]++;
		}
	}
	
	static void topologicalSort() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			if(prevCnt[i] == 0) q.add(new int[] {i, 1});
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sub = cur[0], cnt = cur[1];
			term[sub] = cnt;
			for(int next : list.get(sub)) {
				prevCnt[next]--;
				if(prevCnt[next] == 0) {
					q.add(new int[] {next, cnt+1});
				}
			}
		}
	}
	
}
