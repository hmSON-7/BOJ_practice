package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {
	
	/*
	 * BOJ_15683 : 감시 (Gold_3)
	 * 자료구조 및 알고리즘 : 구현, 시뮬레이션, 브루트포스(백트래킹)
	 *
	 * [문제 요약]
	 * - N x M 크기의 사무실에 벽, 빈칸, 그리고 5종류의 CCTV가 있다.
	 * - CCTV는 90도 회전이 가능하며, 종류에 따라 감시하는 방향이 다르다.
	 * - CCTV가 감시할 수 없는 사각지대의 최소 크기를 구하라.
	 *
	 * [핵심 아이디어]
	 * - CCTV의 개수가 최대 8개로 적으므로, 모든 CCTV의 방향을 정하는 경우의 수를 백트래킹으로 구한다.
	 * - 각 CCTV의 방향이 모두 정해지면(Depth 도달), 시뮬레이션(watch)을 통해 감시 영역을 체크한다.
	 * - 전체 빈 칸의 개수에서 감시된 영역의 수를 빼면 사각지대의 크기가 나온다.
	 *
	 * [구현 메모]
	 * - CCTV 5번은 회전해도 모양이 같으므로 경우의 수가 1개, 2번은 가로/세로 2개이다.
	 * - 이를 백트래킹 조건문에서 분기 처리하여 탐색 공간을 최적화했다.
	 * - minArea가 0이 되면 더 줄일 수 없으므로 `flag`를 이용해 전체 탐색을 조기 종료한다.
	 *
	 * [시간 복잡도]
	 * - 최악의 경우(모두 1,3,4번 CCTV): 4^8 = 65,536가지 경우의 수.
	 * - 각 경우마다 O(R*C) 시뮬레이션. 충분히 시간 내 통과 가능하다.
	 */
	
	static int r, c, len; // 행, 열, CCTV 개수
	static int invisibleCnt, totalArea = 0, minArea; // 현재 사각지대 수, 전체 빈칸 수, 최소 사각지대 수
	static boolean flag; // 최적해(0) 발견 시 조기 종료 플래그
	static char[][] map; // 사무실 상태 맵
	static boolean[][] visible; // 시뮬레이션용 방문(감시) 체크 배열
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1}; // 상, 우, 하, 좌
	
	static List<CCTV> list = new ArrayList<>(); // CCTV 목록
	static int[] selected; // 각 CCTV가 바라볼 방향 인덱스 저장
	
	static class CCTV {
		int y, x, num; // 좌표, CCTV 종류(1~5)
		
		public CCTV(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visible = new boolean[r][c]; // 크기만 할당, 매 시뮬레이션마다 초기화됨
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				char ch = st.nextToken().charAt(0);
				
				if(ch == '0') totalArea++; // 빈 칸 개수 카운트
				else if(ch >= '1' && ch <= '5') {
					list.add(new CCTV(i, j, ch - '0'));
					len++;
				}
				map[i][j] = ch;
			}
		}
		
		minArea = totalArea; // 초기값은 전체 빈 칸의 수
		selected = new int[len];
	}
	
	// 백트래킹: 각 CCTV의 방향을 결정
	static void backtrack(int idx, int cnt) {
		if(flag) return; // 이미 사각지대 0을 찾았으면 탐색 중단
		
		// 모든 CCTV의 방향을 결정했다면 시뮬레이션 시작
		if(cnt == len) {
			// 이번 시뮬레이션을 위해 visible 배열 초기화
			for(int i=0; i<r; i++) {
				Arrays.fill(visible[i], false);
			}
			
			invisibleCnt = totalArea; // 사각지대 초기값 = 전체 빈칸
			
			// 결정된 방향(selected)대로 감시 시작
			for(int i=0; i<len; i++) {
				setDirection(i);
			}
			
			// 최소 사각지대 갱신
			if(invisibleCnt < minArea) {
				minArea = invisibleCnt;
			}
			// 사각지대가 0이면 더 이상 볼 필요 없음 (Global Optimum)
			if(minArea == 0) flag = true;
			
			return;
		}
		
		CCTV cctv = list.get(idx);
		// CCTV 종류에 따라 회전 경우의 수 가지치기
		if(cctv.num == 5) {
			// 5번은 4방향 모두 보므로 회전 의미 없음 (1가지)
			selected[cnt] = 0;
			backtrack(idx+1, cnt+1);
		} else if(cctv.num == 2) {
			// 2번은 (좌우) 또는 (상하) 2가지 경우
			for(int i=0; i<2; i++) {
				selected[cnt] = i;
				backtrack(idx+1, cnt+1);
			}
		} else {
			// 1, 3, 4번은 90도씩 4방향 회전 가능
			for(int i=0; i<4; i++) {
				selected[cnt] = i;
				backtrack(idx+1, cnt+1);
			}
		}
	}
	
	// 선택된 방향(dir)에 따라 CCTV의 실제 감시 방향 설정
	static void setDirection(int idx) {
		int dir = selected[idx]; // backtrack에서 정한 기준 방향
		CCTV cctv = list.get(idx);
		
		switch(cctv.num) {
			case 1 : 
				watch(cctv.y, cctv.x, dir); // 한 방향
				break;
			case 2 : 
				watch(cctv.y, cctv.x, dir);
				watch(cctv.y, cctv.x, dir+2); // 반대 방향 (상하 or 좌우)
				break;
			case 3 :
				watch(cctv.y, cctv.x, dir);
				watch(cctv.y, cctv.x, (dir+1)%4); // 직각 방향
				break;
			case 4 :
				watch(cctv.y, cctv.x, dir);
				watch(cctv.y, cctv.x, (dir+1)%4);
				watch(cctv.y, cctv.x, (dir+2)%4); // 세 방향 ('ㅜ' 모양)
				break;
			case 5 : 
				// 4방향 모두
				watch(cctv.y, cctv.x, 0);
				watch(cctv.y, cctv.x, 1);
				watch(cctv.y, cctv.x, 2);
				watch(cctv.y, cctv.x, 3);
		}
	}
	
	// 특정 방향으로 감시 수행 (직선으로 뻗어나감)
	static void watch(int sy, int sx, int dir) {
		int y = sy + dy[dir];
		int x = sx + dx[dir];
		
		// 맵 범위 내이고, 벽(6)이 아닐 때까지 직진
		while(isIn(y, x) && map[y][x] != '6') {
			// 아직 감시되지 않은 구역이라면 체크
			if(!visible[y][x]) {
				visible[y][x] = true;
				
				// 해당 구역이 빈 칸('0')이었다면 사각지대 개수 감소
				// (CCTV나 벽은 사각지대 카운트 대상이 아님)
				if(map[y][x] == '0') invisibleCnt--;
			}
			
			y += dy[dir];
			x += dx[dir];
		}
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		backtrack(0, 0);
		
		System.out.println(minArea);
	}

}