package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {

	static int n, m, maxHacked;
	static List<List<Integer>> comList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// ���� ��ǻ���� ���� �ŷ� ������ ��
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// �� ��ǻ�Ϳ� ���� �ŷ� ����Ʈ ����
		for(int i=0; i<n; i++) {
			comList.add(new ArrayList<>());
		}
		
		// �׷��� ����
		// ��Ŀ�� �ŷ� ���踦 ������ �̿��Ͽ� �ŷڹ޴� ��ǻ�ͺ��� ��ŷ�ؾ� ȿ�����̹Ƿ� �������� ����Ʈ�� ���� �߰�
		// �ŷڹ޴� ��� ��ǻ�� -> Ÿ���� �ŷ��ϴ� ��ǻ��
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int trust = Integer.parseInt(st.nextToken()) - 1;
			int target = Integer.parseInt(st.nextToken()) - 1;
			comList.get(target).add(trust);
		}
		maxHacked = 1;
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// ���� ��ǻ���� ���� �ŷ� ������ ��
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// �� ��ǻ�Ϳ� ���� �ŷ� ����Ʈ ����
		for(int i=0; i<n; i++) {
			comList.add(new ArrayList<>());
		}
		
		// �׷��� ����
		// ��Ŀ�� �ŷ� ���踦 ������ �̿��Ͽ� �ŷڹ޴� ��ǻ�ͺ��� ��ŷ�ؾ� ȿ�����̹Ƿ� �������� ����Ʈ�� ���� �߰�
		// �ŷڹ޴� ��� ��ǻ�� -> Ÿ���� �ŷ��ϴ� ��ǻ��
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int trust = Integer.parseInt(st.nextToken()) - 1;
			int target = Integer.parseInt(st.nextToken()) - 1;
			comList.get(target).add(trust);
		}
		maxHacked = 1;
	}
	
	public static void solve() {
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<n; i++) {
			// �� ��ǻ�ͺ��� �����ϴ� BFS �˰���
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(i);
			// �ߺ� ����
			boolean[] visited = new boolean[n];
			visited[i] = true;
			// ��ŷ�� �� �ִ� ��ǻ�� ��
			int hackedCnt = 1;
			
			while(!q.isEmpty()) {
				List<Integer> nextList = comList.get(q.poll());
				for(int j=0; j<nextList.size(); j++) {
					int value = nextList.get(j);
					if(visited[value]) continue;
					visited[value] = true;
					hackedCnt++;
					q.offer(value);
				}
			}
			
			// Ž�� ����� ���� ��ϵ� �ִ� ��ǻ�� ������ ũ�ٸ� �� ���� �� ����� ��ǻ�� ����Ʈ �ʱ�ȭ
			// Ž�� ����� ���� ��ϵ� �ִ� ��ǻ�� ���� �����ϴٸ� ����� ��ǻ�� ����Ʈ�� �ش� ��ǻ�� �ε��� �߰�
			if(hackedCnt > maxHacked) {
				result.clear();
				result.add(i+1);
				maxHacked = hackedCnt;
			} else if(hackedCnt == maxHacked) result.add(i+1);
		}
		
		// ����Ʈ ���
		StringBuilder sb = new StringBuilder();
		for(int x : result) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
	
}
