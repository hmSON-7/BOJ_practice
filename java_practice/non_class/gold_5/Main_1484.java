package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1484 {
	
	/*
	 * BOJ_1484 : 다이어트(Gold_5)
	 * 자료구조 및 알고리즘 : 수학, 투 포인터
	 * 
	 * 문제에서 말하는 킬로그램 G는 현재 몸무게의 제곱 - 기존 몸무게의 제곱이다. 해당 공식을 성립하는 경우들의 현재 몸무게 후보를 출력해야 한다.
	 * 최소 몸무게인 1은 left로, 그 다음인 2를 right로 잡고 right^2 - left^2와 G를 비교한다.
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		// 공식이 성립하는 현재 몸무게 목록
		List<Integer> list = new ArrayList<>();
		
		// 투 포인터 설정 및 연산
		int left = 1, right = 2;
		while(left < right) {
			int diff = (right*right) - (left*left);
			if(diff < g) right++;
			else if(diff > g) left++;
			else {
				list.add(right++);
				left++;
			}
		}
		
		// 만약 공식이 성립하는 경우가 없다면
		if(list.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int w : list) {
			sb.append(w + "\n");
		}
		System.out.println(sb);
	}

}
