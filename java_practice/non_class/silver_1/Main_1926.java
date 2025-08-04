package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {
	
	/**
	 * BFS�� ȥ���� �迭 ���� Ž�� ����
	 * ��� �迭�� ���鼭 �׸��� �׷��� ����(1)�� �߰��ϸ� �� ��ǥ�� �������� BFS�� ����
	 * Ž�� �������� �̹� ������ ������ ���� 0���� �����Ͽ� �ߺ� ����
	 * �迭 ��ȸ ������ 1�� ������ �߰��� ������ drawCnt ����
	 * BFS�� Ž���� ������ ���� ��� ī��Ʈ�ϰ�, Ž�� ���� �� maxArea �� ����
	*/

	// ���� ���� ����, ����, �׸� ���� ī��Ʈ, ���� ���� �׸��� ����
	static int r, c, drawCnt = 0, maxArea = 0;
	// �� ����. 0�� 1�� ����ϹǷ� �޸� ������ ���� boolean Ÿ�� ���
	static boolean[][] map;
	// ��Ÿ �迭. ���� �� �� �� �� ������
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	// BFS Ž���� ť
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		init(); solve();
	}
	
	// �� ���� �ʱ�ȭ �޼���
	// ���� ũ�⸦ �Է¹��� �� �� ������ ���� 1�̸� true, 0�̸� false �Է�
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new boolean[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}
	}
	
	// �迭 ���� Ž�� �� ��� ��� �޼���
	// �׸��� �����ϸ� bfs Ž�� ����
	// �迭 ��ȸ ���� �� �׸��� �ִ� ���� ���
	public static void solve() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				// false�� �����ϴ� ĭ�� ����
				if(!map[i][j]) continue;
				// true�� ĭ�� �����ϹǷ� �׸� �� ī��Ʈ �� BFS ����
				drawCnt++;
				int area = bfs(i, j);
				// ��� ����
				if(area > maxArea) maxArea = area;
			}
		}
		System.out.println(drawCnt + "\n" + maxArea);
	}
	
	// BFS Ž�� �޼���
	// �ʱ� ��ǥ�� �޾� ť�� �Է��ϰ� ť�� �� ������ Ž�� ����
	// Ž�� �������� ���ǿ� �´� ������ Ž���� ��� ���� ī��Ʈ
	public static int bfs(int y, int x) {
		int cnt = 1;
		q.add(new int[]{y, x});
		// �̹� Ž���� ��ġ�� false�� ���� -> �ߺ� ����
		map[y][x] = false;
		while(!q.isEmpty()) {
			// ���� ������ ��ġ�� ��ǥ
			int[] curr =q.poll();
			int currY = curr[0], currX = curr[1];
			// 4���� Ž��
			for(int i=0; i<4; i++) {
				int newY = currY + dy[i];
				int newX = currX + dx[i];
				// �ٶ󺸴� ������ �� �ܺΰų�, �׸��� ���� ����(0)�̸� ����
				if(!isIn(newY, newX) || !map[newY][newX]) continue;
				// �ߺ� ������ ���� �׸� ����
				map[newY][newX] = false;
				q.add(new int[] {newY, newX});
				// ���� ī��Ʈ
				cnt++;
			}
		}
		
		// BFS Ž�� ����. �ش� �׸��� ���̸� solve()�� ��ȯ
		return cnt;
	}
	
	// �迭 ���� �ʰ� ���� �޼���
	public static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
}
