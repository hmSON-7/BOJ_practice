package Rank5.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197 {
	
	// 정점과 간선의 수, 최상위 노드 관리 배열과 간선 관리 배열
	static int v, e;
	static int[] arr;
	static Edge[] edgeList;
	
	// 간선 클래스 : 시작점, 도착점, 비용을 저장
	// cost 기준 오름차순 정렬 지원
	static class Edge implements Comparable<Edge>{
		int start, end, cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		edgeList = new Edge[e];
		arr = new int[v+1];
		for(int i=1; i<=v; i++) {
			arr[i] = i;
		}
		
		// 간선 저장
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, cost);
		}
		// 기본 정렬이 cost 기준 오름차순으로 되어있음
		Arrays.sort(edgeList);
		
		System.out.println(makeTree());
	}
	
	static int makeTree() {
		// 남은 간선 선택 수, 비용 합계
		int cnt = v-1, totalCost = 0;
		for(Edge e : edgeList) {
			// 사이클 차단
			if(find(e.start) == find(e.end)) continue;
			cnt--;
			// 두 정점의 최상위 노드를 일치시킴
			union(e.start, e.end);
			totalCost += e.cost;
			
			// v-1개의 간선을 모두 선택
			if(cnt == 0) return totalCost;
		}
		
		return -1;
	}
	
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		arr[rootB] = rootA;
	}
	
}
