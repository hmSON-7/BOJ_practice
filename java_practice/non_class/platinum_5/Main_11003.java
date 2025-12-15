package platinum_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11003 {
	
	/*
	 * BOJ_11003 : 최솟값 찾기(Platinum_5)
	 * 자료구조 및 알고리즘 : 슬라이딩 윈도우(Sliding Window), 단조 덱(Monotonic Deque)
	 *
	 * [문제 요약]
	 * - N개의 수 A_1, ..., A_N이 주어진다.
	 * - 각 i에 대해 구간 [i-L+1, i] 사이의 최솟값 D_i를 구해서 출력하라.
	 * - (단, 인덱스가 음수인 경우 무시한다.)
	 *
	 * [핵심 아이디어]
	 * - 구간마다 매번 최솟값을 찾으면 O(N*L)이 되어 시간 초과가 발생한다. (N=5,000,000)
	 * - 덱(Deque)을 이용해 윈도우 내부의 값들을 관리하되, '오름차순'이 유지되도록 한다.
	 * - 1. 덱의 뒤(tail)에서 현재 값보다 큰 값들은 모두 제거한다. (현재 값이 더 작고 최신이므로, 큰 값들은 쓸모가 없다)
	 * - 2. 덱의 앞(head)에서 윈도우 범위를 벗어난 인덱스는 제거한다.
	 * - 3. 덱의 맨 앞(head)에 있는 값이 항상 해당 구간의 최솟값이 된다.
	 *
	 * [구현 메모]
	 * - Java의 Deque 인터페이스는 객체 생성 비용 및 오버헤드가 있어, N이 클 때 느릴 수 있다.
	 * - 따라서 int[] 배열과 head, tail 포인터를 이용해 덱을 직접 구현하여 성능을 극대화했다.
	 * - 덱에는 값이 아닌 '인덱스'를 저장하여 윈도우 범위를 판단한다.
	 *
	 * [시간 복잡도]
	 * - 각 원소는 덱에 정확히 한 번 들어가고, 최대 한 번 나온다.
	 * - 따라서 O(N)의 선형 시간 복잡도를 가진다.
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken()); // 윈도우 크기 L
		
		// 덱 구현을 위한 배열과 포인터
		// arr: 입력값 저장, deq: 인덱스 저장
		int[] arr = new int[n], deq = new int[n];
		int head = 0, tail = 0;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			// 1. 윈도우 범위 벗어난 값 제거 (Pop Front)
			// deq[head]는 현재 최솟값의 인덱스.
			// 현재 인덱스 i에서 len만큼 뺀 위치(i - len)보다 같거나 작다면 유효범위 밖임.
			if(head < tail && deq[head] <= i - len) head++;
			
			// 2. 현재 값보다 큰 값 제거 (Pop Back) - 핵심 로직
			// 들어올 값(arr[i])보다 덱의 끝에 있는 값이 크다면, 그 값은 절대 최솟값이 될 수 없음.
			// 이를 반복하여 덱을 항상 오름차순(단조 증가) 상태로 유지함.
			while(head < tail && arr[deq[tail-1]] > arr[i]) tail--;
			
			// 3. 현재 인덱스 추가 (Push Back)
			deq[tail++] = i;
			
			// 4. 최솟값 출력 (Get Min)
			// 덱의 구조상 맨 앞(head)이 항상 최솟값임.
			sb.append(arr[deq[head]]).append(' ');
		}
		
		System.out.println(sb);
	}

}