package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {
	
	// SWEA_2001 : �ĸ���ġ
	// �迭���� (0, 0)���� ���� ��ġ������ �������� �迭�� �����ϰ�, ������ ���� Ư�� ������ ���� �������� ���ϴ� ������� �ۼ�
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	// ���� �迭�� ũ���, �ĸ� ��ġ ������ ����
	static int n, range;
	// �ش� �迭���� �� ��ġ�� �ĸ��� ���� �ƴ�, �������� ��
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			solve(i);
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		memo = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int x = Integer.parseInt(st.nextToken());
				memo[i][j] = x + memo[i][j-1] + memo[i-1][j] - memo[i-1][j-1];
			}
		}
	}
	
	public static void solve(int idx) {
		sb.append("#").append(idx).append(" ");
		int maxCnt = 0;
		for(int i=range; i<=n; i++) {
			for(int j=range; j<=n; j++) {
				int killCnt = memo[i][j] - memo[i-range][j] - memo[i][j-range] + memo[i-range][j-range];
				if(killCnt > maxCnt) maxCnt = killCnt;
			}
		}
		sb.append(maxCnt).append("\n");
	}
}
