package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1058 {
	
	static int v;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(i == j || arr[j][i] >= 3) continue;
				for(int k=0; k<v; k++) {
					if(k == i || k == j) continue;
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		
		int maxCnt = 0;
		for(int i=0; i<v; i++) {
			int cnt = 0;
			for(int j=0; j<v; j++) {
				if(arr[i][j] < 3 && arr[i][j] > 0) cnt++;
			}
			
			if(cnt > maxCnt) maxCnt = cnt;
		}
		
		System.out.println(maxCnt);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		arr = new int[v][v];
		for(int i=0; i<v; i++) {
			Arrays.fill(arr[i], 3);
			arr[i][i] = 0;
		}
		
		for(int i=0; i<v; i++) {
			String line = br.readLine();
			for(int j=0; j<v; j++) {
				char c = line.charAt(j);
				if(c == 'Y') arr[i][j] = 1;
			}
		}
	}

}
