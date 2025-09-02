package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
	
	// ������ ������ ��
	static int v, e;
	// ����ġ�� ���� �������
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		init();
		floydWarshall();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				// ������ ���� �ִ밪�̶��? 0���� ���
				// �׷��� �ʴٸ� �� ����� ����ġ ���
				sb.append(map[i][j] == 20_000_001 ? 0 : map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		map = new int[v][v];
		for(int i=0; i<v; i++) {
			Arrays.fill(map[i], 20_000_001);
			map[i][i] = 0;
		}
		
		for(int i=0; i<e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			// ���� �ߺ� �Է��� �Ͼ �� ����. �� �� ����ġ�� �ּ��� ������ �߰��ؾ� ��.
			if(map[from][to] <= cost) continue;
			map[from][to] = cost;
		}
	}
	
	static void floydWarshall() {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(i == j) continue;
				for(int k=0; k<v; k++) {
					if(k==i || k==j) continue;
					// �� ������ �ٸ� ������ �̵��� �� �ݵ�� ������ i�� ��ġ�� ����� ��� �հ� ����
					// ���� ���� ������ ����ġ���� ��� �հ谡 �۴ٸ� ����ġ ����
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}
	}

}
