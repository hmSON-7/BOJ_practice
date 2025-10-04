package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1068 {
	
	static List<Integer>[] list;
	static int cnt = 0;
	static int target, start;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				start = i; continue;
			}
			list[parent].add(i);
		}
		
		target = Integer.parseInt(br.readLine());
		if(target == start) {
			System.out.println(0);
			return;
		}
		preorder(start, -1);
		System.out.println(cnt);
		
	}
	
	static void preorder(int root, int parent) {
		
		List<Integer> childs = list[root];
		if(childs.size() == 0) {
			cnt++; return;
		}
		
		boolean flag = false;
		for(int c : childs) {
			if(c == target) continue;
			preorder(c, root);
			flag = true;
		}
		
		if(!flag) cnt++;
		
	}

}
