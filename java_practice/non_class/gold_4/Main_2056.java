package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2056 {
	
	// BOJ_2056 : 작업(Gold_4)
	// 사용 알고리즘 : 우선순위 큐, 위상 정렬
	
	// 정점 수
	static int v;
	// 각 작업별 소요 시간, 각 작업별 선행 작업 수
	static int[] elapsed, prev;
	// 단방향 인접 리스트
	static List<Integer>[] list;
	
	static class Node implements Comparable<Node> {
		int id, cost;
		
		public Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정점(작업) 수
		v = Integer.parseInt(br.readLine());
		
		elapsed = new int[v];
		prev = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 각 작업의 소요 시간
			elapsed[i] = Integer.parseInt(st.nextToken());
			// 각 작업별 선행 작업 수
			int reqCnt = Integer.parseInt(st.nextToken());
			for(int k=0; k<reqCnt; k++) {
				int prevId = Integer.parseInt(st.nextToken()) - 1;
				list[prevId].add(i);
				prev[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		// 최종 작업 시간 기록
		int totalTime = 0;
		
		// 선행 작업이 여러 개인 경우 가장 소요 시간이 긴 선행 작업을 마친 뒤에 작업을 시작할 수 있음
		// 따라서 우선순위 큐를 사용, 정렬 기준은 총 소요 시간
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i=0; i<v; i++) {
			// prev[i] == 0 : 선행 작업이 없으면 큐에 등록
			if(prev[i] == 0) q.add(new Node(i, elapsed[i]));
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 작업 소요 시간의 최대값 갱신
			if(cur.cost > totalTime) totalTime = cur.cost;
			
			for(int next : list[cur.id]) {
				// 선행 작업 완료의 의미로 prev 디카운트
				prev[next]--;
				
				// 디카운트 이후 선행 작업 수가 0이 되었다면 마찬가지로 큐에 등록
				// 선행 작업이 여러 개였던 경우 소요 시간이 제일 긴 작업을 마지막으로 수행하였기 때문에
				// 마지막 작업까지의 소요 시간 + 다음 작업의 소요 시간을 기록
				if(prev[next] != 0) continue;
				q.add(new Node(next, cur.cost + elapsed[next]));
			}
		}
		
		System.out.println(totalTime);
	}

}
