package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int v, e;
	static char[] color;
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while(tc --> 0) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			color = new char[v];
			Arrays.fill(color, 'w');
			for(int i=0; i<v; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken())-1;
				int v2 = Integer.parseInt(st.nextToken())-1;
				
				list.get(v1).add(v2);
				list.get(v2).add(v1);
			}
			
			boolean flag = true;
			for(int i=0; i<v; i++) {
				if(color[i] != 'w') continue;
				flag = bfs(i);
				if(!flag) break;
			}
			
			sb.append(flag ? "YES" : "NO").append("\n");
			list.clear();
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : list.get(cur)) {
				if(color[next] != 'w') {
					if(color[next] == color[cur]) {
						return false;
					}
					continue;
				}
				if(color[cur] == 'r') {
					color[next] = 'b';
				} else {
					color[next] = 'r';
				}
				q.add(next);
			}
		}
		
		return true;
	}
	
}
