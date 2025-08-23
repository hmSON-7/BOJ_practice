package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Main.Cave;

public class Main_4485 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int[][] map, lost;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		int tc = 1;
		while(true) {
			init();
			if(n == 0) break;
			sb.append("Problem ").append(tc++).append(": ");
			dijkstra();
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		if(n == 0) return;
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 각 구역별 최소 손실비용 측정
		// 최소비용 측정을 위해 초기값 최대로 설정
		lost = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(lost[i], Integer.MAX_VALUE);
		}
	}
	
	static void dijkstra() {
		// 우선순위 큐 생성. 정렬 기준은 각 구역까지 이동하는 데 소모한 비용
		PriorityQueue<Cave> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		q.add(new Cave(0, 0, map[0][0]));
		lost[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Cave cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(!isIn(ny, nx)) continue;
				int totalCost = cur.cost + map[ny][nx];
				if(ny == n-1 && nx == n-1) {
					sb.append(totalCost).append("\n");
					return;
				}
				if(lost[ny][nx] <= totalCost) continue;
				lost[ny][nx] = totalCost;
				q.add(new Cave(ny, nx, totalCost));
			}
		}
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}
	
	static class Cave {
		int y, x, cost;

		public Cave(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
}
