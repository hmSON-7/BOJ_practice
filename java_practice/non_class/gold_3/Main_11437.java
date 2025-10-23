package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11437 {
	
	// BOJ_11437 : LCA(Gold_3)
	// 자료구조 및 알고리즘 : 트리, LCA(최소 공통 조상)
	// 트리가 주어지고, 이후 두 개의 정점 번호가 주어지면 두 정점의 가장 가까운 공통 조상을 출력해야 한다.
	
	// 정점 수
	static int v;
	// 각 정점의 깊이와 부모 노드의 번호
	static int[] depth, parent;
	// 양방향 인접 리스트
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		
		// 각 정점의 깊이
		// 아직 방문하지 않은 정점은 -1, 루트 노드인 0은 반드시 0
		depth = new int[v];
		Arrays.fill(depth, -1); depth[0] = 0;
		
		// 각 정점의 부모 노드 번호
		// 루트 노드인 0은 부모 노드가 없으므로 -1
		parent = new int[v]; parent[0] = -1;
		list = new ArrayList[v];
		for(int i=0; i<v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		// 트리 순회
		// 각 정점의 부모 노드 번호와 깊이 저장
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				// 양방향 인접 리스트였으므로 이미 방문한 정점은 걸러내야 함
				if(depth[next] >= 0) continue;
				
				q.add(next);
				depth[next] = depth[cur] + 1;
				parent[next] = cur;
			}
		}
		
		int query = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<query; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			
			// 먼저 두 정점의 깊이가 동일할 때까지 한 쪽의 정점 번호를 부모 노드 번호로 변경한다.
			int d1 = depth[v1], d2 = depth[v2];
			while(d1 > d2) {
				v1 = parent[v1];
				d1--;
			}
			while(d1 < d2) {
				v2 = parent[v2];
				d2--;
			}
			
			// 두 정점의 깊이가 동일해졌다면, 두 정점의 값이 동일해질 때까지 비교
			// 동일하지 않은 경우 양쪽 다 부모 노드로 이동
			while(true) {
				if(v1 == v2) {
					sb.append((v1+1) + "\n");
					break;
				}
				
				v1 = parent[v1];
				v2 = parent[v2];
			}
		}
		
		System.out.println(sb);
	}

}
