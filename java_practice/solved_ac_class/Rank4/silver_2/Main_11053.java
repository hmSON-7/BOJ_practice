package Rank4.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// �κ� ������ �ִ� ũ�⸦ ���
		int max = 0;
		
		// ������ ���� ����
		int[] arr = new int[n];
		// �� ���Ҹ� ���������� �ϴ� ���� �κм����� ����
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			arr[i] = next;
			// �ʱⰪ�� ��� 1
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) dp[i]++; 
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
}
