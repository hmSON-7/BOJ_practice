package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main_2665 {
	
	static int n;
	static boolean[][] map;
	static int[][] dist;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	static class Node {
		int y, x, cost;
		
		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		dist = new int[n][n];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = line.charAt(j) == '1';
			}
			
			Arrays.fill(dist[i], n*2);
		}
	}
	
	static int zeroOneBfs() {
		Deque<Node> deq = new ArrayDeque<>();
		deq.addLast(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!deq.isEmpty()) {
			Node cur = deq.removeFirst();
			for(int i=0; i<4; i++) {
				int y = cur.y + dy[i];
				int x = cur.x + dx[i];
				if(!isIn(y, x)) continue;
				
				if(y == n-1 & x == n-1) return cur.cost;
				
				if(map[y][x]) {
					if(dist[y][x] <= cur.cost) continue;
					deq.addFirst(new Node(y, x, cur.cost));
					dist[y][x] = cur.cost;
				} else {
					if(dist[y][x] <= cur.cost+1) continue;
					deq.addLast(new Node(y, x, cur.cost+1));
					dist[y][x] = cur.cost+1;
				}
			}
		}
		
		return -1;
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(zeroOneBfs());
	}

}
