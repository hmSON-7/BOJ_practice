package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	
	// 최대 점프 가능 횟수, 맵 크기
	static int jump, w, h;
	// 맵 정보. 벽은 true, 평지는 false
	static boolean[][] map;
	// 3차원 비트배열. 각 지역마다 점프 몇 번으로 도착했는지 체크하기 위함
	static int[][] visited;
	// h: 나이트 이동, d: 일반 4방향 이동
	static int[] hy = {-2, -2, -1, 1, 2, 2, 1, -1}, dy = {-1, 0, 0, 1};
	static int[] hx = {-1, 1, 2, 2, 1, -1, -2, -2}, dx = {0, -1, 1, 0};
	
	static class Node {
		// 현재 위치 좌표, 이동 횟수, 점프 횟수
		int h, w, moveCnt, jumpCnt;
		
		public Node(int h, int w, int moveCnt, int jumpCnt) {
			this.h = h;
			this.w = w;
			this.moveCnt = moveCnt;
			this.jumpCnt = jumpCnt;
		}
		
		// 초기 세팅용 매개변수 없는 생성자
		public Node() {
			this(0, 0, 0, 0);
		}
	}
	
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
		// 맵 크기가 1 -> 시작점과 도착점이 동일. 동작 수 0 출력
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
			
			// 아직 점프 횟수를 다 채우지 않았다면 점프로 이동하는 경우의 수를 고려하기
			// 각 방향을 확인하면서 이동 가능한 위치에 같은 점프 횟수로 이동한 전적이 없다면 이동
			if(cur.jumpCnt < jump) {
				for(int i=0; i<8; i++) {
					ny = cur.h + hy[i];
					nx = cur.w + hx[i];
					
					// 배열 범위 초과 방지 & 다음 위치에 이미 같은 점프 횟수로 방문한 기록이 있다면 무시
					if(!isIn(ny, nx) || (visited[ny][nx] & (1 << (cur.jumpCnt+1))) != 0) continue;
					
					// 다음 위치가 도착점이라면 이동 횟수 출력 후 즉시 종료
					if(ny == h-1 && nx == w-1) {
						System.out.println(cur.moveCnt + 1);
						System.exit(0);
					}
					// 각 위치에 대한 점프 횟수별 방문 여부 처리는 비트마스킹으로 처리
					visited[ny][nx] |= 1 << (cur.jumpCnt+1);
					q.add(new Node(ny, nx, cur.moveCnt + 1, cur.jumpCnt + 1));
				}
			}
			// 점프 가능 여부와 별개로 일반 이동은 필수적으로 확인
			// 마찬가지로 각 방향을 확인하면서 이동 가능한 위치에 같은 점프 횟수로 이동한 전적이 없다면 이동
			for(int i=0; i<4; i++) {
				ny = cur.h + dy[i];
				nx = cur.w + dx[i];
				
				// 배열 범위 초과 방지 & 다음 위치에 이미 같은 점프 횟수로 방문한 기록이 있다면 무시
				if(!isIn(ny, nx) || (visited[ny][nx] & (1 << cur.jumpCnt)) != 0) continue;
				
				// 다음 위치가 도착점이라면 이동 횟수 출력 후 즉시 종료
				if(ny == h-1 && nx == w-1) {
					System.out.println(cur.moveCnt + 1);
					System.exit(0);
				}
				// 각 위치에 대한 점프 횟수별 방문 여부 처리는 비트마스킹으로 처리
				visited[ny][nx] |= 1 << cur.jumpCnt;
				q.add(new Node(ny, nx, cur.moveCnt + 1, cur.jumpCnt));
			}
			
		}
		
		// 어떤 방식으로도 이동할 수 없다면 -1 출력
		System.out.println(-1);
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < h && x < w && !map[y][x];
	}
	
}
