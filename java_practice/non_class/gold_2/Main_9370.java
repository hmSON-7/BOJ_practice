package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9370 {
	
	// BOJ_9370 : 미확인 도착지(Gold_2)
	// 자료구조 및 알고리즘 : 다익스트라
	
	// 양방향 가중치 그래프의 정보, 시작 위치, 도착 위치의 후보군, 반드시 통과해야 하는 경로 path를 구성하는 두 개의 정점이 주어진다.
	// 도착 위치 후보군들 중 최단 경로 내부에 반드시 통과해야 하는 경로 path가 포함되어 있는 도착 위치의 목록을 구해야 한다.
	// 출력해야 하는 도착 위치의 목록은 반드시 1개 이상이다.
	
	// IO Handler
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	// 정점 수, 간선 수, 도착지점 후보군 수, 시작 위치, 반드시 통과해야 할 두 교차로의 위치
	static int v, e, targetCnt, start, v1, v2;
	// 시작 지점부터 각 위치까지 이동할 때의 최단거리
	static int[] dist;
	// 도착 지점 후보군 목록
	static int[] candidates;
	// 양방향 인접 리스트
	static List<Node>[] list;
	
	static class Node {
		// 목표 위치와 비용
		int to, cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		targetCnt = Integer.parseInt(st.nextToken());
		dist = new int[v];
		// 최단거리 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		candidates = new int[targetCnt];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		v1 = Integer.parseInt(st.nextToken()) - 1;
		v2 = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			// 일반 경로와, 반드시 지나야 하는 경로를 구분할 필요가 있었음
			// 따라서 모든 경로에 2를 곱한 뒤, 특정 경로만 1을 빼 짝수/홀수로 경로를 구분한다.
			// 일반 경로 : 짝수
			// 반드시 지나야 하는 경로 : 홀수
			int cost = Integer.parseInt(st.nextToken()) * 2;
			
			// 만약 반드시 지나야 하는 두 정점이 모두 주어지면 홀수로 변경
			if((from == v1 && to == v2) || (from == v2 && to == v1)) cost--;
			
			// 양방향 인접리스트
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		// 도착 위치 후보군 목록
		for(int i=0; i<targetCnt; i++) {
			candidates[i] = Integer.parseInt(br.readLine()) - 1;
		}
		// 출력시 오름차순으로 출력해야 하므로 미리 정렬해두기
		// 최대 12이므로 시간을 크게 소모하지 않음
		Arrays.sort(candidates);
	}
	
	static void dijkstra() {
		// 정렬 기준 : 현재까지 이동한 거리 오름차순
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 이미 더 짧은 경로로 도착했던 경우 더 탐색하지 않음
			if(dist[cur.to] < cur.cost) continue;
			
			for(Node next : list[cur.to]) {
				int newCost = cur.cost + next.cost;
				if(dist[next.to] <= newCost) continue;
				
				dist[next.to] = newCost;
				q.add(new Node(next.to, newCost));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			init();
			dijkstra();
			
			// 도착 위치 후보군 중 반드시 지나야 하는 경로를 지났는지 확인
			// 해당 위치로 이동이 가능하면서, 이동거리가 홀수인 경우 해당 경로를 지난 것임
			for(int c : candidates) {
				if(dist[c] != Integer.MAX_VALUE && dist[c] % 2 == 1) sb.append((c+1) + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
