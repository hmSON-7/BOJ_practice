package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146 {

	static int n;
	static boolean[][] map;
	static int[][][] spreadMap;
	static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1 , 0};
	static Queue<int[]> qEdge = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		spreadMap = new int[n][n][2];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
	}
	
	static void solve() {
		int islandCnt = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!map[i][j]) continue;
				checkIsland(i, j, islandCnt);
				islandCnt++;
			}
		}
		
		System.out.println(spread());
	}
	
	static void checkIsland(int y, int x, int idx) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y, x});
		map[y][x] = false;
		spreadMap[y][x][0] = idx;
		spreadMap[y][x][1] = 0;
		qEdge.add(new int[] {y, x, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0], cx = cur[1];
			for(int i=0; i<4; i++) {
				int ny = cy + dy[i], nx = cx + dx[i];
				if(!isIn(ny, nx) || !map[ny][nx]) continue;
				map[ny][nx] = false;
				q.add(new int[] {ny, nx});
				spreadMap[ny][nx][0] = idx;
				spreadMap[ny][nx][1] = 0;
				qEdge.add(new int[] {ny, nx, 0});
			}
		}
	}
	
	static int spread() {
		int len = 200, turnFlag = 200;
		while(!qEdge.isEmpty()) {
			int[] cur = qEdge.poll();
			int cy = cur[0], cx = cur[1], turn = cur[2];
			if(turn > turnFlag) break;
			int[] curInfo = spreadMap[cy][cx];
			for(int i=0; i<4; i++) {
				int ny = cy + dy[i], nx = cx + dx[i];
				if(!isIn(ny, nx)) continue;
				int[] nextInfo = spreadMap[ny][nx];
				if(nextInfo[0] != 0) {
					if(nextInfo[0] == curInfo[0]) continue;
					len = Math.min(len, nextInfo[1] + curInfo[1]);
					turnFlag = turn;
				}
				spreadMap[ny][nx][0] = curInfo[0];
				spreadMap[ny][nx][1] = curInfo[1] + 1;
				qEdge.add(new int[] {ny, nx, turn+1});
			}
		}
		
		return len;
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}
	
}
