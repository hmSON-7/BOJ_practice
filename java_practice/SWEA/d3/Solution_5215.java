package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, limit, maxSat;
	static int[] satisfaction, cals;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			bt(0, 0, 0, 0);
			sb.append(maxSat).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		satisfaction = new int[n];
		cals = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			satisfaction[i] = Integer.parseInt(st.nextToken());
			cals[i] = Integer.parseInt(st.nextToken());
		}
		maxSat = 0;
	}
	
	public static void bt(int start, int cnt, int currCal, int currSat) {
		if(cnt == n || start == n || currCal == limit) {
			if(currSat > maxSat) maxSat = currSat;
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(currCal + cals[i] > limit) {
				if(currSat > maxSat) maxSat = currSat;
				continue;
			}
			bt(i+1, cnt+1, currCal + cals[i], currSat + satisfaction[i]);
		}
	}
}
