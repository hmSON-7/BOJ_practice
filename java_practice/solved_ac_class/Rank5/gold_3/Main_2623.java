package Rank5.gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623 {
	
	// BOJ_2623 : 음악프로그램(Gold_3)
	// 자료구조 및 알고리즘 : 위상 정렬
	
	static StringBuilder sb = new StringBuilder();
	
	// 정점(가수) 수
	static int v;
	// 각 가수별 출연 순서가 우선인 다른 가수의 수
	static int[] prev;
	// 인접 리스트
	static List<Integer>[] list;
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점 수와 조사에 참여한 PD의 수
		v = Integer.parseInt(st.nextToken());
		int pd = Integer.parseInt(st.nextToken());
		
		prev = new int[v];
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<pd; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			// 단방향 그래프 구현을 위해 출연 순서가 바로 앞인 가수의 번호를 미리 저장해야 함
			// 각 PD가 조사한 첫번째 가수를 prevId에 등록
			int prevId = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j=1; j<cnt; j++) {
				// 두번쨰 가수부터는 직전의 가수보다 반드시 출연 순서가 뒤에 있어야 함
				int x = Integer.parseInt(st.nextToken()) - 1;
				list[prevId].add(x);
				prev[x]++;
				prevId = x;
			}
		}
	}
	
	static boolean topologySort() {
		// 사이클이 존재하는 그래프인지 확인하기 위해
		// 방문한 정점(가수)의 수를 기록
		int visitCnt = 0;
		
		Queue<Integer> q = new ArrayDeque<>();
		// 출연 순서를 확정하는 데에 문제가 없는 가수들은 큐에 등록함과 동시에 visitCnt 추가
		for(int i=0; i<v; i++) {
			if(prev[i] > 0) continue;
			q.add(i);
			visitCnt++;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			// 현재 출연 순서가 확정된 가수들은 미리 스트링빌더에 등록
			// 사이클이 발생하여 출연 순서 확정이 불가능한 경우 그 이전의 출연 순서를 출력하면 안되기 때문에,
			// 반드시 StringBuilder로 기록한 뒤 문제가 없음을 확인하고 출력해야 함
			sb.append((cur+1) + "\n");
			
			// cur 번호를 가진 가수의 출연 순서가 확정 되었으므로 그 뒤의 순서가 되어야 하는 가수들의 prev를 디카운트
			// 마찬가지로 prev[i] == 0이 되어 출연 순서가 확정된 가수가 존재하면 visitCnt 증가
			for(int next : list[cur]) {
				prev[next]--;
				if(prev[next] > 0) continue;
				q.add(next);
				visitCnt++;
			}
		}
		
		// visitCnt가 정점 개수와 동일 -> 그래프 전체를 순회하였음
		// visitCnt가 정점 개수보다 작음 -> 최소 1번의 사이클 발생으로 인해 그래프 전체를 순회하지 못하였음
		return visitCnt == v;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		// 위상정렬 결과에 따라 출력이 다름
		// 그래프 전체 순회에 성공한 경우 StringBuilder에 저장된 출연 순서룰 출력
		// 그래프 전체 순회에 실패한 경우 0만 출력
		System.out.println(topologySort() ? sb : 0);
	}

}
