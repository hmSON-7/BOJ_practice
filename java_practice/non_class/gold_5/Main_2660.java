package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_2660 {
	
	static int v;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(i == j || arr[j][i] >= v) continue;
				for(int k=0; k<v; k++) {
					if(k == i || k == j) continue;
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		
		TreeSet<Integer> set = new TreeSet<>();
		int min = v;
		for(int i=0; i<v; i++) {
			int cnt = 0;
			for(int j=0; j<v; j++) {
				if(i == j) continue;
				if(arr[i][j] > cnt) cnt = arr[i][j];
			}
			
			if(cnt < min) {
				set.clear();
				min = cnt;
				set.add(i+1);
			} else if(cnt == min) {
				set.add(i+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min + " " + set.size() + "\n");
		for(int x : set) {
			sb.append(x + " ");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		arr = new int[v][v];
		for(int i=0; i<v; i++) {
			Arrays.fill(arr[i], v);
			arr[i][i] = 0;
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if(v1 == -1) break;
			
			arr[v1-1][v2-1] = 1;
			arr[v2-1][v1-1] = 1;
		}
	}

}
