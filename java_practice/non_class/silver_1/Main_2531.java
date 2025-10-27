package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531 {
	
	// BOJ_2531 : 회전 초밥(Silver_1)
	// 자료구조 및 알고리즘 : 브루트포스, 투 포인터, 슬라이딩 윈도우
	// 회전초밥 벨트의 임의의 한 위치부터 K개의 접시를 연속해서 먹으면 할인을 받는다. 즉, K개의 연속된 접시를 선택할 것이다.
	// 추가로, 각 고객은 초밥 하나를 무료로 받는 쿠폰을 하나씩 가진다. 벨트 위에 없더라도 요리사가 새로 만들어준다.
	// 이 손님의 목적은 위의 조건을 철저하게 지키면서도 최대한 다양한 종류의 초밥을 먹는 것이다. 최대 몇 종류의 초밥을 먹을 수 있을까?
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 각각 벨트 위의 초밥 수, 초밥의 종류, 연속해서 먹어야 하는 초밥의 수, 쿠폰으로 받을 수 있는 초밥 번호
		int n = Integer.parseInt(st.nextToken());
		int maxIdx = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken()) - 1;
		
		// 벨트 위의 초밥 번호 배열, 손님이 선택한 각 스시의 개수
		int[] belt = new int[n];
		int[] sushi = new int[maxIdx];
		for(int i=0; i<n; i++) {
			belt[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		// 초기 세팅. 첫 초밥부터 k개의 초밥을 선택한다.
		// 이후 쿠폰을 포함하지 않은 초밥 종류를 cnt에, 쿠폰을 포함한 초밥 종류를 max에 저장한다.
		int cnt = 0, max = 0;
		for(int i=0; i<k; i++) {
			int id = belt[i];
			if(sushi[id] == 0) cnt++;
			sushi[id]++;
		}
		max = cnt;
		if(sushi[coupon] == 0) max++;
		
		// 슬라이딩 윈도우
		// 가장 앞에 있는 초밥은 디카운트, 다음에 오는 새 초밥은 카운트한다.
		// 선택된 초밥의 종류 수를 센 뒤, 추가로 쿠폰에 적힌 초밥까지 적용하여 최대값을 갱신한다.
		// 최대값이 k+1이 되는 순간 더 이상의 탐색은 의미 없다 -> 루프 종료
		int left = 0, right = k-1;
		while(max < k+1 && left < n-1) {
			int leftIdx = belt[left++], rightIdx = belt[(++right)%n];
			sushi[leftIdx]--;
			if(sushi[leftIdx] == 0) cnt--;
			sushi[rightIdx]++;
			if(sushi[rightIdx] == 1) cnt++;
			
			max = Math.max(max, cnt + (sushi[coupon] == 0 ? 1 : 0));
		}
		
		System.out.println(max);
	}

}
