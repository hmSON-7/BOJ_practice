package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13325 {
	
	static int level, n, sum;
	static int[] arr, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		level = Integer.parseInt(br.readLine());
		sum = 0;
		n = (int)Math.pow(2, level+1) - 1;
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			sum += x;
			arr[i] = x;
		}
		
		postorder(0);
		System.out.println(sum);
	}
	
	static void postorder(int root) {
		if(root * 2 + 1 >= n) {
			dp[root] = arr[root];
			return;
		}
		
		postorder(root * 2 + 1);
		postorder(root * 2 + 2);
		int left = dp[root*2+1], right = dp[root*2+2];
		sum += Math.abs(left - right);
		dp[root] = Math.max(left, right) + arr[root];
	}
	
}
