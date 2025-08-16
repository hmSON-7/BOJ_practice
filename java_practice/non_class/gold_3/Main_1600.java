package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	
	static int jump, w, h;
	static boolean[][] map;
	static int[][] visited;
	static int[] hy = {-2, -2, -1, 1, 2, 2, 1, -1}, dy = {-1, 0, 0, 1};
	static int[] hx = {-1, 1, 2, 2, 1, -1, -2, -2}, dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		init(); 
		bfs();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		jump = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		if(w == 1 && h == 1) {
			System.out.println(0);
			System.exit(0);
		}
		map = new boolean[h][w];
		visited = new int[h][w];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node());
		visited[0][0] = 1;
		int ny, nx;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.jumpCnt < jump) {
				for(int i=0; i<8; i++) {
					ny = cur.h + hy[i];
					nx = cur.w + hx[i];
					if(!isIn(ny, nx) || (visited[ny][nx] & (1 << (cur.jumpCnt+1))) != 0) continue;
					if(ny == h-1 && nx == w-1) {
						System.out.println(cur.moveCnt + 1);
						System.exit(0);
					}
					visited[ny][nx] |= 1 << (cur.jumpCnt+1);
					q.add(new Node(ny, nx, cur.moveCnt + 1, cur.jumpCnt + 1));
				}
			}
			for(int i=0; i<4; i++) {
				ny = cur.h + dy[i];
				nx = cur.w + dx[i];
				if(!isIn(ny, nx) || (visited[ny][nx] & (1 << cur.jumpCnt)) != 0) continue;
				if(ny == h-1 && nx == w-1) {
					System.out.println(cur.moveCnt + 1);
					System.exit(0);
				}
				visited[ny][nx] |= 1 << cur.jumpCnt;
				q.add(new Node(ny, nx, cur.moveCnt + 1, cur.jumpCnt));
			}
			
		}
		
		System.out.println(-1);
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < h && x < w && !map[y][x];
	}
	
	static class Node {
		int h, w, moveCnt, jumpCnt;
		
		public Node(int h, int w, int moveCnt, int jumpCnt) {
			this.h = h;
			this.w = w;
			this.moveCnt = moveCnt;
			this.jumpCnt = jumpCnt;
		}
		
		public Node() {
			this(0, 0, 0, 0);
		}
	}
	
}
