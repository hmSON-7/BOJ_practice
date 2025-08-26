package Rank5.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197 {
	
	// ������ ������ ��, �ֻ��� ��� ���� �迭�� ���� ���� �迭
	static int v, e;
	static int[] arr;
	static Edge[] edgeList;
	
	// ���� Ŭ���� : ������, ������, ����� ����
	// cost ���� �������� ���� ����
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
		
		// ���� ����
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, cost);
		}
		// �⺻ ������ cost ���� ������������ �Ǿ�����
		Arrays.sort(edgeList);
		
		System.out.println(makeTree());
	}
	
	static int makeTree() {
		// ���� ���� ���� ��, ��� �հ�
		int cnt = v-1, totalCost = 0;
		for(Edge e : edgeList) {
			// ����Ŭ ����
			if(find(e.start) == find(e.end)) continue;
			cnt--;
			// �� ������ �ֻ��� ��带 ��ġ��Ŵ
			union(e.start, e.end);
			totalCost += e.cost;
			
			// v-1���� ������ ��� ����
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
