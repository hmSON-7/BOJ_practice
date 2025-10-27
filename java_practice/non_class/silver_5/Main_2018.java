package silver_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2018 {
	
	// BOJ_2018 : 수들의 합 5(Silver_5)
	// 자료구조 및 알고리즘 : 수학, 투 포인터
	// 임의의 자연수 N을 1개 이상의 연속된 수들의 합으로 나타내는 방법의 수를 찾아야 한다.
	// 첫 수를 left 포인터로, 마지막 수를 right 포인터로 지정하여 구간합을 관리한다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 목표 수
		int n = Integer.parseInt(br.readLine());
		
		// 1부터 시작, N 자기 자신 또한 연속된 수 하나의 합으로 나타낼 수 있으므로 기본 cnt는 1
		int left = 1, right = 1, sum = 1, cnt = 1;
		while(right < n) {
			if(sum > n) sum -= left++;
			else if(sum < n) sum += ++right;
			else {
				cnt++;
				sum -= left++;
				sum += ++right;
			}
		}
		
		System.out.println(cnt);
	}

}
