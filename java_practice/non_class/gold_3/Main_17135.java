package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135 {
	
	// 맵 크기, 궁수의 사거리, 최대 적 제거 수
	static int r, c, dist, max = 0;
	// 초기 배열, 브루트포스에 사용할 카피 배열, 궁수 사격 방향
	static int[] map, copy, dy = {0, -1, 0}, dx = {-1, 0, 1};
	// 매 턴마다 궁수가 사격해야 할 타겟 좌표 리스트
	static Queue<int[]> targets = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		init();
		comb(0, 0, 0);
		System.out.println(max);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		map = new int[r];
		copy = new int[r];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				// 각 적의 좌표는 비트마스킹으로 관리
				if(st.nextToken().equals("1")) {
					map[i] |= 1<<j;
				}
			}
		}
	}
	
	static void comb(int start, int cnt, int bit) {
		// 궁수 3명 배치 완료. 캐슬 디펜스 시작
		if(cnt == 3) {
			play(bit);
			return;
		}
		
		// 조합을 이용해 궁수 배치하기
		for(int i=start; i<=c-3+cnt; i++) {
			comb(i+1, cnt+1, bit | 1<<i);
		}
	}
	
	// 캐슬 디펜스 플레이 메서드
	static void play(int bit) {
		copy = Arrays.copyOf(map, r);
		// 현재 성벽의 위치, 현재 게임의 적 처치 수
		int castle = r, cnt = 0;
		while(castle > 0) {
			// 각 궁수 관점에서 적 탐색
			for(int i=0; i<c; i++) {
				if((bit & 1<<i) != 0) bfs(castle, i);
			}
			
			// 각 궁수별로 탐색한 적 위치를 받아 복사본에서 적 제거
			// 단, 여러 궁수가 같은 좌표를 사격하는 경우가 있으므로 해당 위치에 적이 없으면 무시
			while(!targets.isEmpty()) {
				int[] target = targets.poll();
				int ty = target[0], tx = target[1];
				if((copy[ty] & 1<<tx) == 0) continue;
				copy[ty] &= ~(1<<tx);
				cnt++;
			}
			
			// 적이 아래로 한 칸씩 이동하는 것을 성벽이 한 칸 위로 올라가는 것으로 표현
			castle--;
		}
		// 최대값 갱신
		if(cnt > max) max = cnt;
	}
	
	// 각 궁수별 적 탐색용 BFS 메서드
	static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sy, sx, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1], curDist = cur[2];
			for(int i=0; i<3; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				// 배열 범위 초과 방지
				if(!isIn(ny, nx, sy)) continue;
				// 만약 찾는 위치에 적이 있다면 즉시 타겟 큐에 추가 후 탐색 종료
				if((copy[ny] & 1<<nx) != 0) {
					targets.add(new int[] {ny, nx});
					return;
				}
				// 탐색할 의미가 없는 곳은 굳이 큐에 넣지 않음
				if(curDist+1 == dist) continue;
				// 다음 위치 큐에 삽입
				q.add(new int[] {ny, nx, curDist+1});
			}
		}
	}
	
	static boolean isIn(int y, int x, int maxR) {
		return y >= 0 && x >= 0 && y < maxR && x < c;
	}
	
}
