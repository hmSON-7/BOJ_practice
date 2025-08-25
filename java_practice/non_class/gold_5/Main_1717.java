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
			
			// cmd : 0 -> 두 원소 a, b를 합집합으로 만든다 -> 하나의 집합으로 만들기 위해 부모 노드를 통일한다.
			// cmd : 1 -> 두 원소가 같은 집합 내에 존재하는 지 확인 후 결과 출력
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
		
		// 분리 집합 초기 세팅
		arr = new int[n+1];
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
	}
	
	// 두 원소의 최상위 노드를 찾아 한 쪽의 최상위 노드 아래로 다른 최상위 노드를 병합시킨다.
	static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		arr[root1] = root2;
	}
	
	// 최상위 노드를 찾는다.
	// arr[x] == x라면 자신이 곧 최상위 노드이므로 그대로 반환, 아니라면 자신의 부모 노드를 통해 다음 노드 탐색.
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
}
