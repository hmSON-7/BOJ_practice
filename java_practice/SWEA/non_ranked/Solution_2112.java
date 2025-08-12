package non_ranked;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int r, c, k, minAd;
	static int[] bits;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			if(testImpact(0)) {
				sb.append(0).append("\n");
				continue;
			}
			bt(0, 1);
			sb.append(minAd).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// 각 특성을 A = 0, B = 1로 비트 저장
		bits = new int[r];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				int b = Integer.parseInt(st.nextToken());
				if(b == 1) bits[i] = bits[i] | (1 << j);
			}
		}
		// 출력값 초기화
		minAd = r;
	}
	
	public static boolean testImpact(int x) {
		for(int i=0; i<c; i++) {
			// 라인별 상태 체크 플래그. 통과하지 못한 라인이 존재하면 즉시 false 반환
			boolean flag = false;
			
			// 현재 특성 및 중첩 카운트
			int cur = 0, cnt = 0;
			for(int j=0; j<r; j++) {
				// 현재 특성을 확인한 후 이전과 같으면 카운트만 증가, 다르면 초기화 후 카운트 증가
				int curBit = bits[j] & (1<<i);
				if(curBit != cur) {
					cnt = 0; cur = curBit;
				}
				cnt++;
				// 만약 동일 특성이 지정된 수만큼 중첩된 상태라면 해당 라인은 성능 검사 통과
				if(cnt >= k) {
					flag = true;
					break;
				}
			}
			// 성능 검사를 통과하지 못한 라인이 하나라도 있으면 즉시 false 반환
			if(!flag) return false;
		}
		// 모든 라인이 성능 검사 통과
		return true;
	}
	
	public static void bt(int start, int cnt) {
		// 지금까지 투여한 약물이 최소 투여 약물수에 도달한다면 굳이 탐색할 필요 없음
		if(cnt >= minAd) return;
		
		for(int i=start; i<r; i++) {
			// 기존 라인 상태 저장
			int line = bits[i];
			// 약품 A를 투여하여 테스트를 통과했다면 다른 라인을 탐색할 필요가 없음
			// 그렇지 않다면 약품 A 투여 후 다음 라인 탐색
			bits[i] = 0;
			if(testImpact(cnt)) {
				minAd = cnt;
				bits[i] = line;
				break;
			}
			bt(i+1, cnt+1);
			// 약품 B를 투여하여 테스트를 통과했다면 다른 라인을 탐색할 필요가 없음
			// 그렇지 않다면 약품 B 투여 후 다음 라인 탐색
			bits[i] = ~0;
			if(testImpact(cnt)) {
				minAd = cnt;
				bits[i] = line;
				break;
			}
			bt(i+1, cnt+1);
			
			// 라인을 기존 상태로 복귀
			bits[i] = line;
		}
	}
	
}
