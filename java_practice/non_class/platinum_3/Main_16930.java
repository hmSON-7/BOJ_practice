package platinum_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16930 {
	
	static int r, c, dist, sy, sx, fy, fx;
	static int[][] visited;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		init();
		System.out.println(bfs());
	}
	
	// ���� ��ġ�� ��ǥ�� ��� �ð��� �����ϴ� Ŭ����
	static class Node {
		int y, x, elapsed;
		
		public Node(int y, int x, int elapsed) {
			this.y = y;
			this.x = x;
			this.elapsed = elapsed;
		}
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		visited = new int[r][c];
		
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				// ���� -1��, ������ 0����
				visited[i][j] = line.charAt(j) == '#' ? -1 : 0;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken())-1;
		sx = Integer.parseInt(st.nextToken())-1;
		fy = Integer.parseInt(st.nextToken())-1;
		fx = Integer.parseInt(st.nextToken())-1;
	}
	
	static int bfs() {
		// �������� �������� �����Ѱ�? 0�� ����
		if(sy == fy && sx == fx) return 0;
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(sy, sx, 0));
		// �ʱ� ��ġ �湮 ó��. ��, ���� �̵����� ���� ������ 0�� �����ϱ� ���Ͽ� �ʱ� ��ġ�� ���� ������ -1�� ����
		visited[sy][sx] = -1;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y, nx = cur.x;
				// ���� ��ġ���� �̵��� �� �ִ� ��� ĭ Ȯ��
				for(int j=0; j<dist; j++) {
					ny += dy[i];
					nx += dx[i];
					// �迭 ���� ���̰ų� ���� ��� �ش� ������ Ž�� ����
					if(!isIn(ny, nx) || visited[ny][nx] == -1) break;
					
					// �������� �� �� �ִ� ���¶�� ��� �ð� ��ȯ
					if(ny == fy && nx == fx) return cur.elapsed + 1;
					
					// �̵��Ϸ��� ��ġ�� �湮�� ���·� ǥ���ϰ�, ť�� �ش� ��ǥ�� ��� �ð� ����
					if(visited[ny][nx] == 0) {
						visited[ny][nx] = cur.elapsed + 1;
						q.add(new Node(ny, nx, cur.elapsed + 1));
					} else if(visited[ny][nx] == cur.elapsed + 1) continue;
					else break;
				}
			}
		}
		
		// ���������� �̵� ������ ����� ������ ���
		return -1;
	}
	
	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
	
}
