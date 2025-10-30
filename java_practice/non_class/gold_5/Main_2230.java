package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2230 {
	
	/*
	 * BOJ_2230 : 수 고르기(Gold_5)
	 * 자료구조 및 알고리즘 : 정렬, 투 포인터
	 * 
	 * N개의 정수로 이루어진 수열 arr에서 중복을 허용하고 두 수를 골랐을 때, 그 차이가 M 이상이면서 제일 작은 경우를 구해야 한다.
	 * 먼저 수열 arr를 정렬한 두 포인터를 이용해 두 수간의 차이가 작으면 right 포인터를, 크면 left 포인터를 증가시키는 방식으로 처리한다.
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수열의 크기와 목표차
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		// 수열 생성 후 오름차순 정렬
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		// 투 포인터, 차의 최소값
		int left = 0, right = 0, minDiff = Integer.MAX_VALUE;
		while(right < n) {
			int diff = arr[right] - arr[left];
			// 두 수의 차이가 target보다 작으면 right 포인터 증가
			// 두 수의 차이가 target보다 크면 left 포인터 증가
			// 만약 목표차를 가지는 두 수를 찾았다면 즉시 루프 종료
			if(diff < target) right++;
			else {
				minDiff = Math.min(minDiff, diff);
				left++;
				if(diff == target) break;
			}
		}
		
		System.out.println(minDiff);
	}

}
