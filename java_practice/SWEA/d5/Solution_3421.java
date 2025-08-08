package d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_3421 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, deny, combCnt, setBit;
	static int[] bits;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			bt(0, 0);
			sb.append(combCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		deny = Integer.parseInt(st.nextToken());
		
		bits = new int[n];
		for(int i=0; i<deny; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			bits[a] = bits[a] | (1<<b);
			bits[b] = bits[b] | (1<<a);
		}
		combCnt = 1;
		setBit = 0;
	}
	
	public static void bt(int start, int cnt) {
		if(cnt == n) return;
		
		for(int i=start; i<n; i++) {
			if((bits[i] & setBit) != 0) continue;
			
			setBit = setBit | (1 << i);
			combCnt++;
			bt(i+1, cnt+1);
			setBit = setBit & ~(1 << i);
		}
	}
	
}
