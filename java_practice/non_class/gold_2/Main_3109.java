package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	
	static int r, c, pathCnt = 0;
	static boolean[][] map;
	static int[] dy = {-1, 0, 1}, path;
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<r; i++) {
			path[0] = i;
			setPipe(i, 0);
		}
		System.out.println(pathCnt);
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new boolean[r][c];
		path = new int[c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j) == 'x';
			}
		}
	}
	
	public static void setPipe(int y, int x) {
		// ������ ���α��� ������ ���
		if(x == c-1) {
			// ���ݱ��� ������ ��ġ�� ������ ��ġ �� ������ ī��Ʈ
			for(int i=0; i<c; i++) {
				int cy = path[i];
				map[cy][i] = true;
			}
			pathCnt++;
			return;
		}
		
		// ���� ��� Ȯ��
		for(int i=0; i<3; i++) {
			int ny = y + dy[i];
			if(ny < 0 || ny >= r || map[ny][x+1]) continue;
			path[x+1] = ny;
			setPipe(ny, x+1);
			// ������ �ϼ� �� ���� ���͸� ���� ������ ��ġ�� �������ϸ鼭 ����
			if(map[y][x]) return;
		}
		map[y][x] = true;
	}
	
}
