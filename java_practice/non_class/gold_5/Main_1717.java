package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, k;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		init();
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// cmd : 0 -> �� ���� a, b�� ���������� ����� -> �ϳ��� �������� ����� ���� �θ� ��带 �����Ѵ�.
			// cmd : 1 -> �� ���Ұ� ���� ���� ���� �����ϴ� �� Ȯ�� �� ��� ���
			if(cmd == 0) {
				union(a, b);
			} else {
				int root1 = find(a), root2 = find(b);
				sb.append(root1 == root2 ? "YES" : "NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// �и� ���� �ʱ� ����
		arr = new int[n+1];
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
	}
	
	// �� ������ �ֻ��� ��带 ã�� �� ���� �ֻ��� ��� �Ʒ��� �ٸ� �ֻ��� ��带 ���ս�Ų��.
	static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		arr[root1] = root2;
	}
	
	// �ֻ��� ��带 ã�´�.
	// arr[x] == x��� �ڽ��� �� �ֻ��� ����̹Ƿ� �״�� ��ȯ, �ƴ϶�� �ڽ��� �θ� ��带 ���� ���� ��� Ž��.
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
}
