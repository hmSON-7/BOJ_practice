package Rank5.gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[] prevCnt = new int[v];
		
		List<Integer>[] nextList = new ArrayList[v];
		for(int i=0; i<v; i++) {
			nextList[i] = new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken()) - 1;
			int next = Integer.parseInt(st.nextToken()) - 1;
			nextList[prev].add(next);
			prevCnt[next]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<v; i++) {
			if(prevCnt[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+1).append(" ");
			
			for(int next : nextList[cur]) {
				prevCnt[next]--;
				if(prevCnt[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);
	}
	
}
