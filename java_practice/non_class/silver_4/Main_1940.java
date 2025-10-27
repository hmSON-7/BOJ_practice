package silver_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940 {
	
	// BOJ_1940 : 주몽(Silver_4)
	// 자료구조 및 알고리즘 : 정렬, 투 포인터
	// 갑옷 하나를 만들기 위해서 재료 2개가 필요하다.
	// 각 재료는 고유번호를 가진다. 갑옷 하나에 들어가는 두 재료의 번호 합은 반드시 target 값과 같아야 한다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 재료의 수와 목표 수치
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		// 각 재료의 고유번호
		// 모든 값을 입력한 후 오름차순 정렬할 것
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// 양 끝에 두 포인터를 지정
		// 두 수의 합을 target과 비교하여 크면 right 감소, 작으면 left 증가
		// 같으면 갑옷의 개수를 카운트하고 left 증가 및 right 감소
		int left = 0, right = n-1, cnt = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum > target) right--;
			else if(sum < target) left++;
			else {
				cnt++;
				left++; right--;
			}
		}
		
		System.out.println(cnt);
	}

}
