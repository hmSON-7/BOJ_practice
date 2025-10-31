package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
	
	/*
	 * BOJ_3055 : 탈출(Gold_4)
	 * 자료구조 및 알고리즘 : BFS
	 * 
	 * 고슴도치의 초기 위치, 지나갈 수 없는 돌의 위치, 비버 소굴(도착지)의 위치, 물이 찬 지역의 초기 위치가 주어진다.
	 * 각각 S, X, D, *, .(이동할 수 있는 칸)
	 * 물은 매 분마다 상하좌우 4방향으로 한 칸씩 확장된다. 고슴도치 또한 분마다 상하좌우 중 한 칸을 이동할 수 있다.
	 * 고슴도치가 비버 소굴로 도착하는 최단 시간을 구하라. 도착할 수 없거나 그 전에 물에 빠지면 KAKTUS를 출력한다.
	 * 
	 * 먼저, 물의 시작점을 초기 위치로 BFS를 돌려 각 위치까지 물이 도달하는 시간을 배열에 따로 저장한다.
	 * 이후 고슴도치의 초기 위치로 BFS를 돌려 물에 빠지기 전에 비버 소굴로 도착할 수 있는지 검증한다.
	 * */
	
	// 맵의 세로 및 가로 크기, 고슴도치의 초기 좌표
	static int r, c, sy, sx;
	// 맵 정보
	static char[][] map;
	// 각 좌표별 물이 범람하는 시간
	static int[][] sinkTime;
	// 물의 초기 위치 리스트
	static List<int[]> water = new ArrayList<>();
	// 4방향 배열
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	static class Node {
		// 현재 위치 좌표, 이동 시간
		int y, x, time;

		public Node(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		sinkTime = new int[r][c];
		for(int i=0; i<r; i++) {
			// 물이 범람하는 최단 시간을 기록하기 위해 초기값을 INF로 설정
			Arrays.fill(sinkTime[i], Integer.MAX_VALUE);
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				char c = line.charAt(j);
				// 맵 정보 등록
				// 고슴 도치 및 물의 초기 위치 기억
				map[i][j] = c;
				if(c == 'S') { sy = i; sx = j; }
				else if(c == '*') water.add(new int[] {i, j});
			}
		}
	}
	
	// 1. 좌표별로 물이 범람하는 시간대를 기록
	static void makeFlood() {
		Queue<Node> flood = new ArrayDeque<>();
		for(int[] w : water) {
			flood.add(new Node(w[0], w[1], 0));
			sinkTime[w[0]][w[1]] = 0;
		}
		
		while(!flood.isEmpty()) {
			Node cur = flood.poll();
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				// 배열 범위 초과 방지, 중복 방지, 비버 소굴이나 돌로는 확장 불가
				if(!isIn(ny, nx) || sinkTime[ny][nx] <= cur.time + 1
						|| map[ny][nx] == 'D' || map[ny][nx] == 'X') 
					continue;
				
				flood.add(new Node(ny, nx, cur.time+1));
				sinkTime[ny][nx] = cur.time + 1;
			}
		}
	}
	
	// 2. 고슴도치 탈출 가능 여부 검증
	static int run() {
		Queue<Node> path = new ArrayDeque<>();
		path.add(new Node(sy, sx, 0));
		while(!path.isEmpty()) {
			Node cur = path.poll();
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				// 배열 범위 초과 방지, 물이 이미 차있거나, 차오르는 곳으로는 이동 불가
				// 중복 방지 및 돌이 있는 위치로 이동 불가
				if(!isIn(ny, nx) || sinkTime[ny][nx] <= cur.time + 1
						|| map[ny][nx] == 'S' || map[ny][nx] == 'X') 
					continue;
				
				// 비버 소굴에 도착한 경우 즉시 소요 시간 반환
				if(map[ny][nx] == 'D') return cur.time + 1;
				
				map[ny][nx] = 'S';
				path.add(new Node(ny, nx, cur.time + 1));
			}
		}
		
		// 비버 소굴로 도착하지 못한 경우 -> -1 반환
		return -1;
	}
	
	// 배열 범위 초과 방지 메서드
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		makeFlood();
		int res = run();
		
		// 탈출에 성공한 경우 소요 시간 출력, 실패한 경우 KAKTUS 출력
		System.out.println(res == -1 ? "KAKTUS" : res);
	}
	
}
