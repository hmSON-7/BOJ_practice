package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657 {
	
	// BOJ_11657 : 타임머신(Gold_4)
	// 자료구조 및 알고리즘 : 벨만 포드
	// N개의 도시와 한 도시에서 다른 도시로 이동하는 버스 M개가 있다.
	// 이 중에는 시간을 소모하는 일반 버스(비용이 양수) 외에도 순간이동을 하는 버스(비용이 0), 타임 머신(비용이 음수)이 존재한다.
	// 1번 도시를 시작으로 하고, 나머지 도시로 가는 가장 빠른 시간을 구해야 한다.
	// 시간을 무한한 과거로 돌릴 수 있다면(음수 사이클) -1을 출력한다. 또, 각 도시별 최단시간을 출력할 때 이동이 불가능한 도시는 -1로 출력한다.
	
	// 정점 수, 간선 수
	static int v, e;
	// int 타입 범위를 초과하는 엣지 케이스가 존재하므로 dist 배열은 long 타입으로 관리
	static long[] dist;
	// 각 간선의 정보 저장
	static Edge[] edges;
	// 초기값
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge {
		// 각 간선의 시작점, 도착점, 시간
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		dist = new long[v];
		// 거리 배열 초기화, 시작점은 0으로 설정
		Arrays.fill(dist, INF);
		dist[0] = 0L;
		edges = new Edge[e];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from,to, cost);
		}
	}
	
	static boolean bellmanFord() {
		// 최단 경로 - 벨만 포드 알고리즘
		// v-1회만큼 최단 거리 계산 작업을 반복
		// 이후 다시 간선들을 순회하며, v번쨰 순회하는 경우에도 값 변경이 일어난다면 이는 무한히 감소하는 음수 사이클이 존재하는 것임.
		// 그렇지 않다면 정상적인 그래프
		for(int i=0; i<v-1; i++) {
			for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
		}
		
		// 음수 사이클 판정
		// 한 번이라도, 최단거리 추가 감소가 일어난다면 음수 사이클이 존재한다는 것을 증명
		for(Edge e : edges) {
			if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                return false;
            }
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		// 벨만 포드 알고리즘을 통해 음수 사이클 발견시
		if(!bellmanFord()) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<v; i++) {
			// 도착할 수 없는 도시는 -1, 그렇지 않은 경우 최단 거리 출력
			sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]).append("\n");
		}
		System.out.println(sb);
	}

}
