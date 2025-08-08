package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {

	static int n, minDist = Integer.MAX_VALUE;
	static int[] s, b;
	
	public static void main(String[] args) throws Exception {
		init(); bt(0, 1, 0);
		System.out.println(minDist);
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void bt(int start, int totalS, int totalB) {
		if(start == n) return;
		
		for(int i=start; i<n; i++) {
			int currS = totalS * s[i];
			int currB = totalB + b[i];
			int dist = Math.abs(currS - currB);
			if(dist < minDist) minDist = dist;
			bt(i+1, currS, currB);
		}
	}
	
}
