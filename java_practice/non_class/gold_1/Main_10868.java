package gold_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10868 {
	
	static int n, p;
	static int[] arr;
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		build();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if (a > b) { 
				int t = a; a = b; b = t; 
			}
			
			sb.append(getMin(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void build() {
		p = 1;
		while (p < n) p = p << 1;
		tree = new int[2 * p];
		for(int i=0; i<2*p; i++) {
		    tree[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<n; i++) {
	        tree[p + i] = arr[i];
	    }
		
		for(int i=p-1; i>0; --i) {
			tree[i] = Math.min(tree[i << 1], tree[i << 1 | 1]);
		}
	}
	
	static int getMin(int start, int end) {
		int res = Integer.MAX_VALUE;
		
		start += p; end += p;
        while (start <= end) {
            if ((start & 1) == 1) res = Math.min(res, tree[start++]);
            if ((end & 1) == 0) res = Math.min(res, tree[end--]);
            start >>= 1; end >>= 1;
        }
        return res;
	}

}
