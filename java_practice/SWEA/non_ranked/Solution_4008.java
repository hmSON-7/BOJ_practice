package non_ranked;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, maxRes, minRes;
	static int[] nums;
	static int[] opCnt = new int[4]; // +, -, *, /
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			calc(nums[0], 1); 
			sb.append(maxRes - minRes).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		maxRes = Integer.MIN_VALUE;
		minRes = Integer.MAX_VALUE;
	}
	
	public static void calc(int currNum, int cnt) {
		if(cnt == n) {
			maxRes = Math.max(maxRes, currNum);
			minRes = Math.min(minRes, currNum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opCnt[i] == 0) continue;
			opCnt[i]--;
			int sum = currNum;
			switch(i) {
				case 0: 
					sum += nums[cnt];
					break;
				case 1:
					sum -= nums[cnt];
					break;
				case 2:
					sum *= nums[cnt];
					break;
				case 3:
					sum /= nums[cnt];
					break;
			}
			calc(sum, cnt+1);
			opCnt[i]++;
		}
	}
	
}
