package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import Main.Node;

public class Main_1743 {
	
	static int r, c, trash;
	static boolean[][] map;
	static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(solve());
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		trash = Integer.parseInt(st.nextToken());
		map = new boolean[r][c];
		for(int i=0; i<trash; i++) {
			st = new StringTokenizer(br.readLine());
			int ty = Integer.parseInt(st.nextToken())-1;
			int tx = Integer.parseInt(st.nextToken())-1;
			map[ty][tx] = true;
		}
	}
	
	static int solve() {
		int max = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(!map[i][j]) continue;
				int area = bfs(i, j);
				if(area > max) max = area;
			}
		}
		
		return max;
	}
	
	
	static int bfs(int sy, int sx) {
		int area = 1;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(sy, sx));
		map[sy][sx] = false;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(!isIn(ny, nx) || !map[ny][nx]) continue;
				map[ny][nx] = false;
				q.add(new Node(ny, nx));
				area++;
			}
		}
		
		return area;
	}
	
	static class Node {
		int y, x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
}
