package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236 {

	// �� ũ��, ��� ũ��, �̵� Ƚ��, ���� ũ���� �� ���� ����� ��
	static int n, size = 2, move = 0, eatCount = 0;
	// �� ���� ��� �ʱ� ��ġ
	static int sy, sx;
	// �� ����. 0 : �� ����, �� �� : �����
	static int[][] map;
	static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
	static boolean[][] visit;
	
	// ��� ��ġ Ŭ����, ���� ��ġ�� �ʱ� ��ġ�κ����� �Ÿ��� ����� ���
	static class Shark {
		int y, x, dist;
		
		public Shark(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {

		init();
		
		// ���� �켱������ �´� ��ġ���� ã�ư��� ���� �켱���� ť ���� ���� ����
        PriorityQueue<Shark> q = new PriorityQueue<>((a, b) ->
                a.dist != b.dist ? Integer.compare(a.dist, b.dist) : // ���� 1 : �Ÿ��� ��
                        a.y != b.y ? Integer.compare(a.y, b.y) : // ���� 2 : ���� ��
                                Integer.compare(a.x, b.x) // ���� 3 : �¿� ��
        );

        // �˰��� ����
        while(true) {
            visit = new boolean[n][n]; // ���� �湮 ���θ� ����
            // ���� ��ġ ���
            q.add(new Shark(sy, sx, 0)); // y��, x��, ���� ��ġ�κ����� �Ÿ�
            
            boolean eat = false; // ���̸� �Ծ��� �� Ȯ��
            visit[sy][sx] = true; // ���� ��ġ Ȯ��

            while(!q.isEmpty()) {
                Shark cur = q.remove();

                // 1. ���� : ���� ���� �� �ִ� ������ΰ�?
                if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < size) {
                	map[cur.y][cur.x] = 0; // ����� ����
                    eatCount++; // ���� ����� ī��Ʈ ����
                    eat = true; // ���� ����Ⱑ ������ üũ
                    move += cur.dist; // ������ �Ÿ��� �� ������ �Ÿ��� �߰�
                    sy = cur.y;
                    sx = cur.x;
                    break;
                }

                // 2. �̵��� �� �ִ� ��ġ�� ť�� ���� ����
                for (int i=0; i<4; i++) {
                    int y = cur.y + dy[i]; // y��
                    int x = cur.x + dx[i]; // x��

                    if (y < 0 || x < 0 || x >= n || y >= n || visit[y][x] || map[y][x] > size)
                        continue; // �̵��� �� ���ų� �̹� �̵��ߴ� ��ġ�� ť�� �������� ����

                    q.add(new Shark(y, x, cur.dist + 1));
                    visit[y][x] = true;
                }
            }

            if(!eat) break; // ť�� ������� ���� ���� �� ���ٸ� ���� �� �ִ� ����Ⱑ ���ٴ� �ǹ�. �˰��� ����

            // 3. �� �ڽ��� ũ�� ��ŭ�� ����⸦ �Ծ��ٸ�?
            if(size == eatCount) {
                size++;
                eatCount = 0;
            }

            q.clear(); // ���� ť�� ���� ��ǥ���� ��� ���� �˰��򿡼� �ʿ䰡 �����Ƿ� ����
        }

        System.out.println(move);
    }
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                	sy = i; sx = j;
                	map[i][j] = 0;
                }
            }
        }
	}
	
}
