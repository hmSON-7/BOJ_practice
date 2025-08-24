package Rank4.gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {

	// 마을 수, 도로 수, 파티가 열리는 마을 번호
		static int n, road, party;
		// 도로 인접리스트 -> 파티 후 귀가할 때 각 학생별 소요 시간 탐색 목적
		static List<List<Road>> list = new ArrayList<>();
		// 역방향 인접리스트 -> 파티 참석할 때 각 학생별 소요 시간 탐색 목적
		static List<List<Road>> reverseList = new ArrayList<>();
		// 각 학생별 소요 시간 기록
		static int[] personalCost;
		
		// 다익스트라에 활용할 클래스. 각각 도로의 도착지와 소요 시간
		static class Road {
			int target, cost;

			public Road(int target, int cost) {
				this.target = target;
				this.cost = cost;
			}
		}
		
		public static void main(String[] args) throws Exception {
			init();
			// 각각 파티 참석할 때의 소요 시간, 파티 참석 후 귀가할 때의 소요 시간
			dijkstra(false);
			dijkstra(true);
			
			// 왕복시간이 가장 긴 학생의 왕복시간 출력
			int max = 0;
			for(int i=0; i<n; i++) {
				max = Math.max(max,  personalCost[i]);
			}
			System.out.println(max);
		}
		
		static void init() throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			road = Integer.parseInt(st.nextToken());
			party = Integer.parseInt(st.nextToken())-1;
			
			for(int i=0; i<n; i++) {
				reverseList.add(new ArrayList<>());
				list.add(new ArrayList<>());
			}
			personalCost = new int[n];
			
			for(int i=0; i<road; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				reverseList.get(end).add(new Road(start, cost));
				list.get(start).add(new Road(end, cost));
			}
		}
		
		static void dijkstra(boolean flag) {
			// 상황에 따른 리스트 선택. 사실 코드 두 번 쓰기 귀찮아서 이렇게 했음.
			List<List<Road>> curList = flag ? list : reverseList;
			
			// 다익스트라를 위한 우선순위 큐 생성. 정렬 조건은 현재 위치까지 오는 데 소요된 시간
			PriorityQueue<Road> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
			// 최소비용 기록용 배열
			int[] dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[party] = 0;
			q.add(new Road(party, 0));
			while(!q.isEmpty()) {
				Road cur = q.poll();
				if(cur.cost > dist[cur.target]) continue;
				for(Road next : curList.get(cur.target)) {
					int nextCost = cur.cost + next.cost;
					if(nextCost < dist[next.target]) {
						dist[next.target] = nextCost;
						q.add(new Road(next.target, nextCost));
					}
				}
			}
			
			// 각 마을간 이동 시 소요 시간을 개인 왕복시간에 추가
			for(int i=0; i<n; i++) {
				personalCost[i] += dist[i];
			}
		}
	
}
