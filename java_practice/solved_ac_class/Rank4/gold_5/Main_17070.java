package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
	
	// �� ũ��
	static int n;
	// ���� �� ������ ��Ʈ����ŷ���� ����. ���� 1
	static int[] map;
	// �� ��ġ���� ���� ������ ����� ���� ����, �밢, ���� ������ ����
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		init();
		
		// DP�� �̿��� �� ��α��� �̵��� �� �ִ� ����� �� ���
		// ���� ������ : ���� + �밢
		// �밢 ������ : ���� + �밢 + ����
		// ���� ������ : �밢 + ����
		// ��, �� ��ġ�� ���� ��� ����
		// ���� �밢 �������� �� �Ǵ� ���ʿ� ���� ������ ��ġ�� �� ����
		for(int i=1; i<=n; i++) {
			for(int j=2; j<n; j++) {
				if((map[i] & 1<<j) != 0) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				if((map[i] & 1<<(j-1)) == 0 && (map[i-1] & 1<<j) == 0)
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
			}
		}
		
		// �������� ��� ����� ���� �ջ��Ͽ� ���
		int sum = dp[n][n-1][0] + dp[n][n-1][1] + dp[n][n-1][2];
		
		System.out.println(sum);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1];
		dp = new int[n+1][n][3];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int x = Integer.parseInt(st.nextToken());
				// ���� 1�� ǥ��
				if(x == 1) {
					map[i] |= 1<<j;
				}
			}
		}
		
		// �ʱ� ������ ��ġ
		dp[1][0][0] = dp[1][1][0] = 1;
	}

}
