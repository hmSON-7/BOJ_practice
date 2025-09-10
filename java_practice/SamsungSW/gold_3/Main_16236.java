package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Main.Shark;

public class Main_16236 {

	// 맵 크기, 상어 크기, 이동 횟수, 현재 크기일 때 먹은 물고기 수
	static int n, size = 2, move = 0, eatCount = 0;
	// 매 턴의 상어 초기 위치
	static int sy, sx;
	// 맵 정보. 0 : 빈 공간, 그 외 : 물고기
	static int[][] map;
	static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
	static boolean[][] visit;
	
	// 상어 위치 클래스, 현재 위치와 초기 위치로부터의 거리를 멤버로 등록
	static class Shark {
		int y, x, dist;
		
		public Shark(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {

		init();
		
		// 조건 우선순위에 맞는 위치부터 찾아가기 위한 우선순위 큐 정렬 기준 설정
        PriorityQueue<Shark> q = new PriorityQueue<>((a, b) ->
                a.dist != b.dist ? Integer.compare(a.dist, b.dist) : // 조건 1 : 거리차 비교
                        a.y != b.y ? Integer.compare(a.y, b.y) : // 조건 2 : 상하 비교
                                Integer.compare(a.x, b.x) // 조건 3 : 좌우 비교
        );

        // 알고리즘 시작
        while(true) {
            visit = new boolean[n][n]; // 구역 방문 여부를 저장
            // 현재 위치 기록
            q.add(new Shark(sy, sx, 0)); // y축, x축, 현재 위치로부터의 거리
            
            boolean eat = false; // 먹이를 먹었는 지 확인
            visit[sy][sx] = true; // 현재 위치 확인

            while(!q.isEmpty()) {
                Shark cur = q.remove();

                // 1. 조건 : 당장 먹을 수 있는 물고기인가?
                if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < size) {
                	map[cur.y][cur.x] = 0; // 물고기 제거
                    eatCount++; // 먹은 물고기 카운트 증가
                    eat = true; // 먹은 물고기가 있음을 체크
                    move += cur.dist; // 움직인 거리를 총 움직인 거리에 추가
                    sy = cur.y;
                    sx = cur.x;
                    break;
                }

                // 2. 이동할 수 있는 위치를 큐에 전부 저장
                for (int i=0; i<4; i++) {
                    int y = cur.y + dy[i]; // y축
                    int x = cur.x + dx[i]; // x축

                    if (y < 0 || x < 0 || x >= n || y >= n || visit[y][x] || map[y][x] > size)
                        continue; // 이동할 수 없거나 이미 이동했던 위치는 큐에 저장하지 않음

                    q.add(new Shark(y, x, cur.dist + 1));
                    visit[y][x] = true;
                }
            }

            if(!eat) break; // 큐가 비워지는 동안 먹은 게 없다면 먹을 수 있는 물고기가 없다는 의미. 알고리즘 종료

            // 3. 상어가 자신의 크기 만큼의 물고기를 먹었다면?
            if(size == eatCount) {
                size++;
                eatCount = 0;
            }

            q.clear(); // 현재 큐에 남은 좌표들은 모두 다음 알고리즘에서 필요가 없으므로 제거
        }

        System.out.println(move);
    }
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                	sy = i; sx = j;
                	map[i][j] = 0;
                }
            }
        }
	}
	
}
