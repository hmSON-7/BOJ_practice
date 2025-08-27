package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922 {

	static int n;
	static int[] arr;
	static Edge[] edges;
	
	// 각 정점을 잇는 간선 클래스, 두 정점과 연결 비용 포함
	// 비용 기준 정렬 재정의
	static class Edge implements Comparable<Edge> {
		int v1, v2, cost;

		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		Arrays.sort(edges);;
		System.out.println(makeTree());
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		edges = new Edge[e];
		
		StringTokenizer st;
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(v1, v2, cost);
		}
	}
	
	static int makeTree() {
		int total = 0, cnt = 0;
		
		for(Edge e : edges) {
			// 사이클 회피
			if(find(e.v1) == find(e.v2)) continue;
			cnt++;
			total += e.cost;
			union(e.v1, e.v2);
			
			// n-1개의 정점을 모두 선택하면 트리 생성 완료
			if(cnt == n-1) return total;
		}
		
		return -1;
	}
	
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
	static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra == rb) return;
		if(ra < rb) arr[rb] = ra;
		else arr[ra] = rb;
	}
	
}
