package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17325 {
	
	/*
	 * BOJ_17325 : 여러분의 다리가 되어 드리겠습니다! (Gold_5)
	 * 자료구조 및 알고리즘 : 유니온 파인드
	 *
	 * [문제 요약]
	 * - 섬이 N개 있고, 다리가 N-2개만 주어진다(무방향, 연결).
	 * - 즉, 전체 그래프는 정확히 두 개의 연결 요소로 나뉘어 있다.
	 * - 두 연결 요소의 대표 섬 번호(각각 1개씩)를 출력하라. (1-based)
	 *
	 * [접근 아이디어]
	 * - 주어진 N-2개의 간선을 순서대로 유니온한다.
	 * - 모든 섬에 대해 find(i)==i 인 인덱스(루트)를 찾으면, 그게 두 연결 요소의 대표다.
	 * - 루트는 2개가 존재하므로, 두 대표를 출력하면 된다.
	 */
	
	static int[] head; // 대표를 저장하는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 섬의 수
		head = new int[n];
		for (int i = 0; i < n; i++) head[i] = i; // 초기엔 각자 자기 자신이 대표임
		
		// 다리는 N-2개
		for (int i = 0; i < n - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // 0-based
			int b = Integer.parseInt(st.nextToken()) - 1; // 0-based
			union(a, b);
		}
		
		// 두 개의 루트(연결 요소 대표) 찾기
		int rootA = -1, rootB = -1;
		for (int i = 0; i < n; i++) {
			// find(i)==i 인 i가 루트
			if (find(i) == i) {
				if (rootA == -1) rootA = i + 1; // 1-based로 저장
				else { rootB = i + 1; break; }
			}
		}
		
		// 두 대표 출력
		System.out.println(rootA + " " + rootB);
	}
	
	// find(x): x의 대표(루트) 반환 + 경로 압축
	static int find(int x) {
		if (head[x] == x) return x;
		return head[x] = find(head[x]);
	}
	
	// union(a, b): 두 집합을 합친다 (큰 루트를 작은 루트에 연결)
	static void union(int a, int b) {
		int ra = find(a), rb = find(b);
		if (ra == rb) return;
		if (ra > rb) head[ra] = rb;
		else head[rb] = ra;
	}
}
