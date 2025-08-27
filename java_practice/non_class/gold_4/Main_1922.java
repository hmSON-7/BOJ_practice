package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922 {

	static int n;
	static int[] arr;
	static Edge[] edges;
	
	// �� ������ �մ� ���� Ŭ����, �� ������ ���� ��� ����
	// ��� ���� ���� ������
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
			// ����Ŭ ȸ��
			if(find(e.v1) == find(e.v2)) continue;
			cnt++;
			total += e.cost;
			union(e.v1, e.v2);
			
			// n-1���� ������ ��� �����ϸ� Ʈ�� ���� �Ϸ�
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
