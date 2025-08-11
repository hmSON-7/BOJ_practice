package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, maxCollide;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	static int[][] map;
	static int[][] directions = {
			{0, 1, 2, 3},
			{2, 3, 1, 0},
			{1, 3, 0, 2},
			{3, 2, 0, 1},
			{2, 0, 3, 1},
			{2, 3, 0, 1}
	};
	static int[][] holes = new int[5][4];
	
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine().trim());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			simulate();
			sb.append(maxCollide).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n+2][n+2];
		Arrays.fill(map[0],  5);
		Arrays.fill(map[n+1],  5);
		for(int i=0; i<5; i++) {
			Arrays.fill(holes[i], -1);
		}
		for(int i=1; i<=n; i++) {
			map[i][0] = 5; map[i][n+1] = 5;
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1; j<=n; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if(input >= 6) {
					int idx = input - 6;
					if(holes[idx][0] != -1) {
						holes[idx][2] = i;
						holes[idx][3] = j;
					} else {
						holes[idx][0] = i;
						holes[idx][1] = j;
					}
				}
			}
		}
		maxCollide = 0;
	}
	
	public static void simulate() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] != 0) continue;
				for(int d=0; d<4; d++) {
					playPinball(i, j, d);
				}
			}
		}
	}
	
	public static void playPinball(int startY, int startX, int d) {
		int y = startY, x = startX;
		int collideCnt = 0;
		
		while(true) {
			int ny = y + dy[d], nx = x + dx[d];
			if(isEnd(ny, nx, startY, startX)) break;
			if(map[ny][nx] >= 1 && map[ny][nx] <= 5) {
				d = directions[map[ny][nx]][d];
				collideCnt++;
			} else if(map[ny][nx] >= 6 && map[ny][nx] <= 10) {
				int holeNum = map[ny][nx] - 6;
				if(ny == holes[holeNum][0] && nx == holes[holeNum][1]) {
					ny = holes[holeNum][2];
					nx = holes[holeNum][3];
				} else {
					ny = holes[holeNum][0];
					nx = holes[holeNum][1];
				}
			}
			y = ny; x = nx;
			if(isEnd(ny, nx, startY, startX)) break;
		}
		if(collideCnt > maxCollide) maxCollide = collideCnt;
	}
	
	public static boolean isEnd(int y, int x, int startY, int startX) {
		return (y == startY && x == startX) || map[y][x] == -1;
	}
	
}
