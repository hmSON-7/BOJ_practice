package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1516 {
	
	// BOJ_1516 : 게임 개발(Gold_3)
	// 사용한 자료구조 및 알고리즘  : 위상 정렬
	
	// 정점 수
	static int v;
	// 각 작업별 소요 시간, 선행 작업의 개수
	static int[] times, prev;
	// 다음 작업으로 이어지는 인접 리스트
	static List<Integer>[] list;
	
	static class Node implements Comparable<Node>{
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
		v = Integer.parseInt(br.readLine());
		
		times = new int[v];
		prev = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			while(true) {
				// -1이 입력되기 전까지의 모든 값이 선행 작업임.
				// -1이 입력되는 즉시 다음 정점에 대한 입력값을 받음
				int req = Integer.parseInt(st.nextToken()) - 1;
				if(req == -2) break;
				
				list[req].add(i);
				prev[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		// 소요 시간이 가장 짧은 작업부터 처리하기 위해 우선순위 큐 사용
		// 현재 선행작업의 개수가 0인 작업들만 큐에 추가
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i=0; i<v; i++) {
			if(prev[i] == 0) q.add(new Node(i, times[i]));
		}
		
		// 각 작업의 수행 시간을 times 배열에 최종 등록
		// 다음 정점의 존재를 확인할 때마다 prev[i] 디카운트
		// prev[i]가 0이면 큐에 추가
		while(!q.isEmpty()) {
			Node cur = q.poll();
			times[cur.id] = cur.cost;
			
			for(int next : list[cur.id]) {
				prev[next]--;
				if(prev[next] > 0) continue;
				
				q.add(new Node(next, cur.cost + times[next]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<v; i++) {
			sb.append(times[i] + "\n");
		}
		System.out.println(sb);
	}

}
