package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5567 {
	static int n, rel;
	static List<List<Integer>> relation = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		init(); solve();
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 인원 별 친구 리스트 생성. 상근이 본인은 0번에 해당하므로 0번째 인덱스는 방문 여부 true
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			relation.add(new ArrayList<>());
		}
		visited = new boolean[n];
		visited[0] = true;
		
		// 친구 관계 리스트 입력. 각 인덱스의 리스트에 상대방의 번호를 입력하여 쌍방으로 친구임을 표기
		rel = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<rel; i++) {
			st = new StringTokenizer(br.readLine());
			int friendA = Integer.parseInt(st.nextToken()) - 1;
			int friendB = Integer.parseInt(st.nextToken()) - 1;
			relation.get(friendA).add(friendB);
			relation.get(friendB).add(friendA);
		}
	}
	
	public static void solve() {
		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		
		// 각각 현재 거쳐가는 사람의 인덱스와 이동 횟수를 큐에 등록
		// 이동 횟수가 2인 경우 추가로 확장하지 않음
		q.add(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int idx = curr[0], dist = curr[1];
			if(dist >= 2) continue;
			List<Integer> relList = relation.get(idx);
			for(int link : relList) {
				if(visited[link]) continue;
				cnt++;
				visited[link] = true;
				q.add(new int[] {link, dist+1});
			}
		}
		
		System.out.println(cnt);
	}
}
