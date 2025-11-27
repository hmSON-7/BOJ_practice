package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31423 {
	
	/*
	 * BOJ_31423 : 신촌 통폐합 계획 (Gold_5)
	 * 자료구조 및 알고리즘 : 연결 리스트(Linked List), 인덱스 관리
	 *
	 * [문제 요약]
	 * - N개의 대학 이름(문자열)이 주어진다.
	 * - N-1번의 통폐합 명령 (i, j)가 주어지는데, 이는 대학 i의 맨 뒤에 대학 j를 연결한다는 뜻이다.
	 * - 모든 통폐합이 끝난 후 완성된 하나의 대학 이름을 출력하라.
	 *
	 * [핵심 아이디어]
	 * - Java의 String concatenation(+)이나 StringBuilder를 매번 사용하면 메모리 복사가 발생해
	 * 문자열 길이의 합만큼 시간이 걸리므로(최악 O(N^2)), 시간 초과가 발생한다.
	 * - 대신, 각 문자열을 연결 리스트의 노드로 보고 '순서(Next Pointer)'만 관리한다.
	 * - 핵심은 두 리스트를 합칠 때, 앞 리스트의 '맨 끝(Tail)'에 뒤 리스트의 '맨 앞(Head)'을 연결하는 것이다.
	 * - 이를 위해 각 그룹의 시작점(Head) 뿐만 아니라 끝점(Tail)의 인덱스도 함께 관리해야 한다.
	 *
	 * [구현 메모]
	 * - next[i]: i번 대학 다음에 오는 대학의 인덱스.
	 * - tail[i]: i번 대학이 속한(또는 i번이 대표인) 연결 리스트의 '가장 마지막' 대학 인덱스.
	 * - 병합 로직: tail[from]의 next를 to로 설정하고, from의 tail 정보를 to의 tail로 갱신한다.
	 *
	 * [시간 복잡도]
	 * - 병합 연산은 포인터 갱신만 하므로 O(1). 총 N-1회 수행 시 O(N).
	 * - 마지막 순회 및 출력이 전체 문자열 길이(L)만큼 소요.
	 * - 전체 복잡도: O(N + L).
	 */
	
	static int n;
	static String[] name; // 각 대학의 이름 문자열
	static int[] next;    // next[i] = i번 대학 바로 뒤에 붙는 대학 인덱스 (링크)
	static int[] tail;    // tail[i] = i번 대학이 포함된 체인의 '가장 마지막' 대학 인덱스
	static boolean[] isMerged; // isMerged[i] = i번 대학이 다른 대학 뒤로 흡수되었는지 여부
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		name = new String[n];
		next = new int[n];
		tail = new int[n];
		isMerged = new boolean[n];
		
		// 초기화
		for(int i=0; i<n; i++) {
			name[i] = br.readLine();
			next[i] = -1; // 다음 대학 없음
			tail[i] = i;  // 자기 자신이 끝(Tail)
		}
		
		// N-1번의 병합 연산 수행
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1; // 1-based -> 0-based
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			// [병합 로직: from 뒤에 to를 붙임]
			
			// 1. 링크 연결 (from의 '현재 끝부분' 다음에 to를 연결)
			// next[from]이 -1이라면(처음 병합), next[from] = to
			// 이미 from 뒤에 무언가 있다면, 그 체인의 끝(tail[from]) 뒤에 to를 연결
			if(next[from] == -1) next[from] = to;
			else next[tail[from]] = to;
			
			// 2. Tail 정보 갱신
			// from 그룹의 새로운 끝은 to 그룹의 끝이 됨
			tail[from] = tail[to];
			
			// 3. 흡수 처리
			// to는 이제 누군가의 뒤에 붙었으므로 더 이상 시작점(Head)이 될 수 없음
			isMerged[to] = true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		StringBuilder sb = new StringBuilder();
		
		// 시작점 찾기: 한 번도 누군가의 뒤로 들어가지 않은(isMerged가 false인) 노드가 유일한 Head
		int idx = -1;
		for(int i=0; i<n; i++) {
			if(!isMerged[i]) {
				idx = i; break;
			}
		}
		
		// 연결 리스트 순회하며 출력
		while(idx != -1) {
			sb.append(name[idx]);
			idx = next[idx];
		}
		System.out.println(sb);
	}

}