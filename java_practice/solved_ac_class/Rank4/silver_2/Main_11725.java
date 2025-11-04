package Rank4.silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {
	
	/*
	 * BOJ_11725 : 트리의 부모 찾기(Silver_2)
	 * 자료구조 및 알고리즘 : 트리, BFS
	 * 
	 * 루트 없는 트리의 루트를 1로 정했을 때, 각 노드의 부모를 구해야 한다.
	 * 양방향 그래프를 인접 리스트로 구현한 후 1부터 BFS를 시작하는 형태로 각 노드의 부모 노드 번호를 저장한다.
	 */

	// 노드 수
	static int v;
	// 각 노드의 부모 노드 번호
	static int[] prev;
	// 양방향 인접 리스트
	static List<Integer>[] list;
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		prev = new int[v];
		// 모든 값을 미방문을 의미하는 -1로 채우기
		Arrays.fill(prev, -1);
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 양방향 인접 리스트 구현
		for(int i=0; i<v-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			list[from].add(to);
			list[to].add(from);
		}
	}
	
	static void bfs() {
		// BFS로 각 노드의 부모 노드 번호 확인
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		// 쓸데없는 루프 방지를 위해 미리 -1이 아닌 값으로 채운다.
		prev[0] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				// prev[next]가 0 이상인 곳 -> 이미 방문함. 역행을 방지하기 위함임.
				if(prev[next] != -1) continue;
				
				// 노드 추가
				prev[next] = cur;
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		bfs();
		
		// 루트를 제외한 나머지 노드의 부모 노드 번호를 순차적으로 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<v; i++) {
			sb.append((prev[i]+1) + "\n");
		}
		System.out.println(sb);
	}
	
}
