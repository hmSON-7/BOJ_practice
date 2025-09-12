package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1719 {
	
	static int v, e;
	static int[][] arr, minCost;
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=1; i<=v; i++) {
			for(int j=1; j<=v; j++) {
				if(i == j || arr[i][j] == -1) continue;
				for(int k=1; k<=v; k++) {
					if(k == i || k == j) continue;
					int sumCost = minCost[j][i] + minCost[i][k];
					if(sumCost < minCost[j][k]) {
						arr[j][k] = arr[j][i];
						minCost[j][k] = sumCost;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=v; i++) {
			for(int j=1; j<=v; j++) {
				sb.append(arr[i][j] == 0 ? "-" : arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new int[v+1][v+1];
		minCost = new int[v+1][v+1];
		for(int i=1; i<=v; i++) {
			Arrays.fill(arr[i], -1);
			Arrays.fill(minCost[i], v * 1000 + 1);
			arr[i][i] = 0;
			minCost[i][i] = 0;
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			arr[v1][v2] = v2;
			arr[v2][v1] = v1;
			minCost[v1][v2] = time;
			minCost[v2][v1] = time;
		}
	}

}
