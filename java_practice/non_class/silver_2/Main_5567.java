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
		
		// �ο� �� ģ�� ����Ʈ ����. ����� ������ 0���� �ش��ϹǷ� 0��° �ε����� �湮 ���� true
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			relation.add(new ArrayList<>());
		}
		visited = new boolean[n];
		visited[0] = true;
		
		// ģ�� ���� ����Ʈ �Է�. �� �ε����� ����Ʈ�� ������ ��ȣ�� �Է��Ͽ� �ֹ����� ģ������ ǥ��
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
		
		// ���� ���� ���İ��� ����� �ε����� �̵� Ƚ���� ť�� ���
		// �̵� Ƚ���� 2�� ��� �߰��� Ȯ������ ����
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
