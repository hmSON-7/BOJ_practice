package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_14002 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] prev = new int[n];
		Arrays.fill(prev, -1);
		Arrays.fill(dp, 1);
		
		int maxLen = 0, maxIdx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			arr[i] = next;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i]++;
					prev[i] = j;
				}
			}
			
			if(dp[i] > maxLen) {
				maxLen = dp[i];
				maxIdx = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxLen + "\n");
		
		Deque<Integer> stack = new ArrayDeque<>();
		while(maxIdx >= 0) {
			stack.addLast(arr[maxIdx]);
			maxIdx = prev[maxIdx];
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast() + " ");
		}
		System.out.println(sb);
	}

}
