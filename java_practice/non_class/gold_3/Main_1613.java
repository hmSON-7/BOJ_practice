package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1613 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int v;
	static boolean[][] arr;
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(i == j || !arr[j][i]) continue;
				for(int k=0; k<v; k++) {
					if(k == i || k == j) continue;
					arr[j][k] = arr[j][k] || arr[i][k];
				}
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		while(tc --> 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			if(arr[v1][v2]) sb.append(-1);
			else if(arr[v2][v1]) sb.append(1);
			else sb.append(0);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		arr = new boolean[v][v];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken()) - 1;
			int after = Integer.parseInt(st.nextToken()) - 1;
			arr[before][after] = true;
		}
	}

}
