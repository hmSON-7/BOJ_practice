package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
	
	static int r, c, maxCnt = 1;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static boolean[] visited = new boolean[26];
	
	public static void main(String[] args) throws Exception {
		init(); dfs(0, 0, 1);
		System.out.println(maxCnt);
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
	}
	
	public static void dfs(int y, int x, int moveCnt) {
		char curr = map[y][x];
		visited[curr - 'A'] = true;
		boolean moveFlag = false;
		for(int i=0; i<4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(!isIn(newY, newX)) continue;
			char next = map[newY][newX];
			if(visited[next - 'A']) continue;
			if(!moveFlag) moveFlag = true;
			dfs(newY, newX, moveCnt+1);
			visited[next - 'A'] = false;
		}
		if(!moveFlag && moveCnt > maxCnt) maxCnt = moveCnt;
 	}
	
	public static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
}
