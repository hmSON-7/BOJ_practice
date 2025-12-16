package Rank6.platinum_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3015 {
	
	/*
	 * BOJ_3015 : 오아시스 재결합(Platinum_5)
	 * 자료구조 및 알고리즘 : 스택(Monotonic Stack)
	 *
	 * [문제 요약]
	 * - 한 줄로 서 있는 사람들 사이에서 서로 볼 수 있는 쌍(Pair)의 수를 구하라.
	 * - 두 사람 사이에 두 사람보다 키가 큰 사람이 없어야 서로 볼 수 있다.
	 *
	 * [핵심 아이디어]
	 * - 스택을 내림차순(Monotonic Decreasing)으로 유지한다.
	 * - 나보다 키가 작은 사람은 나 이후의 사람을 볼 수 없으므로, 쌍을 맺고 스택에서 제거(Pop)한다.
	 * - 키가 같은 사람이 연속될 경우, 이들을 별개의 객체로 두지 않고 {키, 개수} 형태로 압축하여 관리한다.
	 * (예: 키 5인 사람이 3명 -> {5, 3})
	 *
	 * [오답 노트 & 주의점]
	 * - 쌍의 개수(cnt)는 최대 N(N-1)/2까지 나올 수 있다.
	 * - N=500,000일 경우 쌍의 개수(cnt)가 int 범위를 초과하므로 반드시 long 타입을 사용해야 한다.
	 *
	 * [구현 메모]
	 * - stack[i][0]: 키, stack[i][1]: 해당 키를 가진 연속된 사람 수
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 스택 배열: [인덱스][0]=키, [인덱스][1]=중복된 사람 수
		// N만큼 할당하여 동적 리스트 오버헤드 제거
		long[][] stack = new long[n][2];
		int top = 0; // 스택 포인터
		long cnt = 0; // 정답(쌍의 수) - long 타입 필수
		
		for(int i=0; i<n; i++) {
			long x = Long.parseLong(br.readLine()); // 현재 사람의 키
			
			// 1. 스택이 비어있다면 무조건 push
			if(top == 0) {
				stack[top][0] = x;
				stack[top][1] = 1;
				top++;
				continue;
			}
			
			// 2. 나(x)보다 키가 작은 사람들은 나와 쌍을 맺고 스택에서 제거됨 (Pop)
			// 이유: 내가 가로막고 있어서 그들은 내 뒤의 누구도 볼 수 없음
			while(stack[top-1][0] < x) {
				cnt += stack[top-1][1]; // 해당 키를 가진 사람 수만큼 쌍 추가
				top--; // 제거
				
				if(top == 0) break;
			}
			
			// 스택이 비어있지 않다면 (나보다 크거나 같은 사람이 남아있음)
			if(top > 0) {
				// 3. 키가 같은 경우 (압축 로직)
				if(stack[top-1][0] == x) {
					// 기존에 있던 동일 키 사람들과 모두 쌍을 맺음
					long sameCount = stack[top-1][1];
					cnt += sameCount;
					
					// 나 자신을 그 그룹에 합침 (+1)
					stack[top-1][1]++;
					
					// [중요] 동일 키 그룹 뒤에 '더 큰 사람'이 존재한다면 그 사람과도 쌍을 맺음
					// top-2가 존재한다는 건, top-1(현재 같은 키 그룹)보다 큰 사람이 스택 아래에 있다는 뜻
					if(top-2 >= 0) cnt++; 
					
				} else {
					// 4. 스택 top에 있는 사람이 나보다 큰 경우
					// 그 사람과 나는 서로 볼 수 있음 (쌍 1개 추가)
					cnt++;
					
					// 나를 스택에 새로 push
					stack[top][0] = x;
					stack[top][1] = 1;
					top++;
				}
			} else {
				// 스택이 비워졌다면 그냥 push
				stack[top][0] = x;
				stack[top][1] = 1;
				top++;
			}
		}
		
		System.out.println(cnt);
	}

}