package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135 {
	
	// �� ũ��, �ü��� ��Ÿ�, �ִ� �� ���� ��
	static int r, c, dist, max = 0;
	// �ʱ� �迭, ���Ʈ������ ����� ī�� �迭, �ü� ��� ����
	static int[] map, copy, dy = {0, -1, 0}, dx = {-1, 0, 1};
	// �� �ϸ��� �ü��� ����ؾ� �� Ÿ�� ��ǥ ����Ʈ
	static Queue<int[]> targets = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		init();
		comb(0, 0, 0);
		System.out.println(max);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		map = new int[r];
		copy = new int[r];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				// �� ���� ��ǥ�� ��Ʈ����ŷ���� ����
				if(st.nextToken().equals("1")) {
					map[i] |= 1<<j;
				}
			}
		}
	}
	
	static void comb(int start, int cnt, int bit) {
		// �ü� 3�� ��ġ �Ϸ�. ĳ�� ���潺 ����
		if(cnt == 3) {
			play(bit);
			return;
		}
		
		// ������ �̿��� �ü� ��ġ�ϱ�
		for(int i=start; i<=c-3+cnt; i++) {
			comb(i+1, cnt+1, bit | 1<<i);
		}
	}
	
	// ĳ�� ���潺 �÷��� �޼���
	static void play(int bit) {
		copy = Arrays.copyOf(map, r);
		// ���� ������ ��ġ, ���� ������ �� óġ ��
		int castle = r, cnt = 0;
		while(castle > 0) {
			// �� �ü� �������� �� Ž��
			for(int i=0; i<c; i++) {
				if((bit & 1<<i) != 0) bfs(castle, i);
			}
			
			// �� �ü����� Ž���� �� ��ġ�� �޾� ���纻���� �� ����
			// ��, ���� �ü��� ���� ��ǥ�� ����ϴ� ��찡 �����Ƿ� �ش� ��ġ�� ���� ������ ����
			while(!targets.isEmpty()) {
				int[] target = targets.poll();
				int ty = target[0], tx = target[1];
				if((copy[ty] & 1<<tx) == 0) continue;
				copy[ty] &= ~(1<<tx);
				cnt++;
			}
			
			// ���� �Ʒ��� �� ĭ�� �̵��ϴ� ���� ������ �� ĭ ���� �ö󰡴� ������ ǥ��
			castle--;
		}
		// �ִ밪 ����
		if(cnt > max) max = cnt;
	}
	
	// �� �ü��� �� Ž���� BFS �޼���
	static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sy, sx, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1], curDist = cur[2];
			for(int i=0; i<3; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				// �迭 ���� �ʰ� ����
				if(!isIn(ny, nx, sy)) continue;
				// ���� ã�� ��ġ�� ���� �ִٸ� ��� Ÿ�� ť�� �߰� �� Ž�� ����
				if((copy[ny] & 1<<nx) != 0) {
					targets.add(new int[] {ny, nx});
					return;
				}
				// Ž���� �ǹ̰� ���� ���� ���� ť�� ���� ����
				if(curDist+1 == dist) continue;
				// ���� ��ġ ť�� ����
				q.add(new int[] {ny, nx, curDist+1});
			}
		}
	}
	
	static boolean isIn(int y, int x, int maxR) {
		return y >= 0 && x >= 0 && y < maxR && x < c;
	}
	
}
