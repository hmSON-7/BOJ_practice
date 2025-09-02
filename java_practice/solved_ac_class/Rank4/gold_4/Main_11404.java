package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
	
	// 정점과 간선의 수
	static int v, e;
	// 가중치를 담은 인접행렬
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		init();
		floydWarshall();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				// 여전히 값이 최대값이라면? 0으로 출력
				// 그렇지 않다면 각 경로의 가중치 출력
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
			// 간선 중복 입력이 일어날 수 있음. 그 중 가중치가 최소인 간선만 추가해야 함.
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
					// 각 정점이 다른 정점을 이동할 때 반드시 경유지 i를 거치는 경우의 비용 합계 연산
					// 이후 기존 간선의 가중치보다 비용 합계가 작다면 가중치 갱신
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}
	}

}
