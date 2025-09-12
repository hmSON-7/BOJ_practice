package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1261 {
	
	// 각 칸의 좌표와 현재까지 부순 벽의 개수를 기록
	static class Node {
		int y, x, cost;
		
		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// 맵 정보. 0은 빈 방, 1은 벽
		boolean[][] map = new boolean[r][c];
		// 거리 정보. (0, 0)부터 시작하여 벽을 몇 번 부수고 이동했는지 기록
		int[][] dist = new int[r][c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j) == '1';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 맵의 크기가 1X1인 경우 -> 시작점 == 도착점
		if(r == 1 && c == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 0/1(Zero/One) BFS
		// 가중치 변화가 0, 1 뿐인 그래프를 다익스트라로 탐색할 때, 우선순위 큐를 사용하지 않고 Deque를 사용
		// 이동할 때 비용이 들지 않으면 addFirst, 이동할 때 비용이 들면 addLast
		// 위와 같은 방식으로 Deque를 이용해 다익스트라를 흉내내면서 시간복잡도를 크게 줄임
		Deque<Node> dq = new ArrayDeque<>();
		dq.addFirst(new Node(0, 0, 0));
		dist[0][0] = 0;
		while(!dq.isEmpty()) {
			Node cur = dq.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				// 배열 범위 초과 방지, 이미 더 빠르게 도착하였다면 무시
				if(ny < 0 || nx < 0 || ny >= r || nx >= c || dist[ny][nx] <= cur.cost) continue;
				
				// 도착점인 경우
				// 도착점은 벽이 없음을 전제로 하므로 현재까지 부순 벽 수 반환
				if(ny == r-1 && nx == c-1) {
					System.out.println(cur.cost);
					System.exit(0);
				}
				
				// 벽을 부수고 이동하려는 경우
				if(map[ny][nx]) {
					if(dist[ny][nx] <= cur.cost + 1) continue;
					dq.addLast(new Node(ny, nx, cur.cost+1));
					dist[ny][nx] = cur.cost+1;
				}
				// 빈 방으로 이동하려는 경우
				else {
					if(dist[ny][nx] <= cur.cost) continue;
					dq.addFirst(new Node(ny, nx, cur.cost));
					dist[ny][nx] = cur.cost;
				}
				
			}
		}
		
		// 가능성은 없으나, 만약 도착이 불가능한 상황이라면 여기에 그에 따른 코드 작성
		System.out.println(-1);
	}

}
