package Rank5.platinum_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_14003 {
	
	static int[] arr, tails;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		tails = new int[n];
		int[] idxAtLen = new int[n];
		int[] prev = new int[n];
		Arrays.fill(prev, -1);
		
		int curSize = 0;
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			arr[i] = next;
			int res = binarySearch(next, curSize);
			tails[res] = next;
			prev[i] = (res > 0) ? idxAtLen[res-1] : -1;
			idxAtLen[res] = i;
			
			if(res == curSize) curSize++;
		}
		
		int cur = idxAtLen[curSize-1];
		Deque<Integer> stack = new ArrayDeque<>();
		while(cur >= 0) {
			stack.addLast(arr[cur]);
			cur = prev[cur];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(curSize + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast() + " ");
		}
		System.out.println(sb);
	}
	
	static int binarySearch(int x, int size) {
		int left = 0, right = size;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if (tails[mid] < x) left = mid + 1;
            else right = mid;
		}
		
		return left;
	}

}
