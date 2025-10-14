package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1953 {
	
	static int v;
	static char[] colors;
	static List<Integer> blue = new ArrayList<>();
	static List<Integer> white = new ArrayList<>();
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		init();
		for(int i=0; i<v; i++) {
			if(colors[i] != 'u') continue;
			bfs(i);
		}
		
		Collections.sort(blue);
		Collections.sort(white);
		
		StringBuilder sb = new StringBuilder();
		sb.append(blue.size() + "\n");
		for(int member : blue) sb.append(member + " ");
		sb.append("\n");
		sb.append(white.size() + "\n");
		for(int member : white) sb.append(member + " ");
		sb.append("\n");
		
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		colors = new char[v];
		Arrays.fill(colors, 'u');
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hateCnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<hateCnt; j++) {
				int target = Integer.parseInt(st.nextToken()) - 1;
				list[i].add(target);
				list[target].add(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		colors[start] = 'b';
		blue.add(start+1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				if(colors[next] != 'u') continue;
				
				q.add(next);
				if(colors[cur] == 'b') {
					colors[next] = 'w';
					white.add(next+1);
				} else {
					colors[next] = 'b';
					blue.add(next+1);
				}
				
			}
		}
	}

}
