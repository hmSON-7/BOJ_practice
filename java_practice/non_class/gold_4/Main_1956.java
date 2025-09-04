package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956 {
	
	static int v, e, min;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		init();
		floydWarshall();
		
		for(int i=0; i<v; i++) {
			for(int j=i+1; j<v; j++) {
				min = Math.min(min, map[i][j] + map[j][i]);
			}
		}
		
		System.out.println(min == 10_000 * v + 1 ? -1 : min);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new int[v][v];
		for(int i=0; i<v; i++) {
			Arrays.fill(map[i], 10_000 * v + 1);
			map[i][i] = 0;
		}
		min = 10_000 * v + 1;
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			map[v1][v2] = cost;
		}
	}
	
	static void floydWarshall() {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(i==j || map[j][i] == 10_000 * v + 1) continue;
				for(int k=0; k<v; k++) {
					if(k==i || k==j) continue;
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}
	}

}
