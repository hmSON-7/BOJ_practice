package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12893 {
	
	static int v, e;
	static int[] arr;
	static char[] colors;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		init();
		int flag = 1;
		for(int i=0; i<v; i++) {
			if(colors[i] == 'w') {
				int res = bfs(i);
				flag &= res;
			}
			if(flag == 0) break;
		}
		
		System.out.println(flag);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new int[v];
		colors = new char[v];
		Arrays.fill(colors, 'w');
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
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		colors[start] = 'r';
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				char nextColor = colors[next];
				if(nextColor == 'w') {
					q.add(next);
					colors[next] = colors[cur] == 'r' ? 'b' : 'r';
					continue;
				}
				if(nextColor == colors[cur]) return 0;
			}
		}
		
		return 1;
	}

}
