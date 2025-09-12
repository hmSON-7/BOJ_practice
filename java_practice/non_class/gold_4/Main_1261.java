package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1261 {
	
	// �� ĭ�� ��ǥ�� ������� �μ� ���� ������ ���
	static class Node {
		int y, x, cost;
		
		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// �� ����. 0�� �� ��, 1�� ��
		boolean[][] map = new boolean[r][c];
		// �Ÿ� ����. (0, 0)���� �����Ͽ� ���� �� �� �μ��� �̵��ߴ��� ���
		int[][] dist = new int[r][c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j) == '1';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// ���� ũ�Ⱑ 1X1�� ��� -> ������ == ������
		if(r == 1 && c == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 0/1(Zero/One) BFS
		// ����ġ ��ȭ�� 0, 1 ���� �׷����� ���ͽ�Ʈ��� Ž���� ��, �켱���� ť�� ������� �ʰ� Deque�� ���
		// �̵��� �� ����� ���� ������ addFirst, �̵��� �� ����� ��� addLast
		// ���� ���� ������� Deque�� �̿��� ���ͽ�Ʈ�� �䳻���鼭 �ð����⵵�� ũ�� ����
		Deque<Node> dq = new ArrayDeque<>();
		dq.addFirst(new Node(0, 0, 0));
		dist[0][0] = 0;
		while(!dq.isEmpty()) {
			Node cur = dq.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				// �迭 ���� �ʰ� ����, �̹� �� ������ �����Ͽ��ٸ� ����
				if(ny < 0 || nx < 0 || ny >= r || nx >= c || dist[ny][nx] <= cur.cost) continue;
				
				// �������� ���
				// �������� ���� ������ ������ �ϹǷ� ������� �μ� �� �� ��ȯ
				if(ny == r-1 && nx == c-1) {
					System.out.println(cur.cost);
					System.exit(0);
				}
				
				// ���� �μ��� �̵��Ϸ��� ���
				if(map[ny][nx]) {
					if(dist[ny][nx] <= cur.cost + 1) continue;
					dq.addLast(new Node(ny, nx, cur.cost+1));
					dist[ny][nx] = cur.cost+1;
				}
				// �� ������ �̵��Ϸ��� ���
				else {
					if(dist[ny][nx] <= cur.cost) continue;
					dq.addFirst(new Node(ny, nx, cur.cost));
					dist[ny][nx] = cur.cost;
				}
				
			}
		}
		
		// ���ɼ��� ������, ���� ������ �Ұ����� ��Ȳ�̶�� ���⿡ �׿� ���� �ڵ� �ۼ�
		System.out.println(-1);
	}

}
