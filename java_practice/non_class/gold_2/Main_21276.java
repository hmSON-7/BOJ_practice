package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21276 {
	
static StringBuilder sb = new StringBuilder();
	
	static int v;
	static HashMap<String, Integer> nameToId = new HashMap<>();
	static String[] names;
	static int[] prev;
	static List<Integer>[] list, childs;
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		prev = new int[v];
		names = new String[v];
		list = new ArrayList[v];
		childs = new ArrayList[v];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
			childs[i] = new ArrayList<>();
			names[i] = st.nextToken();
		}
		Arrays.sort(names);
		for(int i=0; i<v; i++) nameToId.put(names[i], i);
		
		int e = Integer.parseInt(br.readLine());
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			int idx1 = nameToId.get(name1);
			int idx2 = nameToId.get(name2);
			
			list[idx2].add(idx1);
			prev[idx1]++;
		}
	}
	
	static void topologySort() {
		Queue<Integer> q = new ArrayDeque<>();
		int rootCnt = 0;
		for(int i=0; i<v; i++) {
			if(prev[i] != 0) continue;
			rootCnt++;
			q.add(i);
			sb.append(names[i] + " ");
		}
		sb.insert(0, rootCnt + "\n");
		sb.append("\n");
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			List<Integer> nextList = list[cur];
			nextList.sort((a, b) -> names[a].compareTo(names[b]));
			for(int next : nextList) {
				prev[next]--;
				if(prev[next] > 0) continue;
				
				q.add(next);
				childs[cur].add(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		topologySort();
		
		for(int i=0; i<v; i++) {
			List<Integer> nextList = childs[i];
			sb.append(names[i] + " " + nextList.size() + " ");
			if(nextList.size() == 0) {
				sb.append("\n"); continue;
			}
			for(int next : nextList) {
				sb.append(names[next] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
