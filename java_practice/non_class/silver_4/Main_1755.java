package silver_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main_1755 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		String[] nums = {
				"zero", "one", "two", "three", "four", 
				"five", "six", "seven", "eight", "nine"
		};
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=start; i<=end; i++) {
			String str;
			if(i < 10) str = nums[i];
			else str = nums[i/10] + " " + nums[i%10];
			map.put(str, i);
		}
		
		StringBuilder sb = new StringBuilder();
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		int cnt = 0;
		for(String key : keySet) {
			sb.append(map.get(key) + " ");
			cnt++;
			if(cnt == 10) {
				cnt = 0;
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
