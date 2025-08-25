package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, cities;
	static int[] arr, dest;
	
	public static void main(String[] args) throws Exception {
		init();
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			if(root != find(x)) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		cities = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dest = new int[cities];
		
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				if(st.nextToken().equals("1")) union(i, j);
			}
		}
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
