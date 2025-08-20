package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583 {
	
	static int r, c, rec;
	static boolean[][] filled;
	static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
	static List<Integer> area = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		init(); solve();
		area.sort((a, b) -> a - b);
		StringBuilder sb = new StringBuilder();
		sb.append(area.size()).append("\n");
		for(int a : area) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		rec = Integer.parseInt(st.nextToken());
		filled = new boolean[r][c];
		for(int i=0; i<rec; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					filled[j][k] = true;
				}
			}
		}
	}
	
	static void solve() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(filled[i][j]) continue;
				bfs(i, j);
			}
		}
	}
	
	static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sy, sx});
		filled[sy][sx] = true;
		int areaCnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1];
			for(int i=0; i<4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if(!isIn(ny, nx) || filled[ny][nx]) continue;
				areaCnt++;
				q.add(new int[] {ny, nx});
				filled[ny][nx] = true;
			}
		}
		area.add(areaCnt);
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
}
