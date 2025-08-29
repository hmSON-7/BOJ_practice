package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992 {
	
	static int n;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		init();
		press(0, 0, n);
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = line.charAt(j) == '1';
			}
		}
	}
	
	static void press(int y, int x, int len) {
		if(len == 1 || check(y, x, len)) {
			int res = map[y][x] ? 1 : 0;
			sb.append(res);
			return;
		}
		
		int half = len/2;
		sb.append("(");
		press(y, x, half);
		press(y, x+half, half);
		press(y+half, x, half);
		press(y+half, x+half, half);
		sb.append(")");
	}
	
	static boolean check(int y, int x, int len) {
		boolean flag = map[y][x];
		for(int i=y; i<y+len; i++) {
			for(int j=x; j<x+len; j++) {
				if(flag != map[i][j]) return false;
			}
		}
		
		return true;
	}
	
}
