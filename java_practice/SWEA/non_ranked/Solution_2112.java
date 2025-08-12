package non_ranked;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int r, c, k, minAd;
	static int[] bits;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init();
			sb.append("#").append(i).append(" ");
			if(testImpact(0)) {
				sb.append(0).append("\n");
				continue;
			}
			bt(0, 1);
			sb.append(minAd).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// �� Ư���� A = 0, B = 1�� ��Ʈ ����
		bits = new int[r];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				int b = Integer.parseInt(st.nextToken());
				if(b == 1) bits[i] = bits[i] | (1 << j);
			}
		}
		// ��°� �ʱ�ȭ
		minAd = r;
	}
	
	public static boolean testImpact(int x) {
		for(int i=0; i<c; i++) {
			// ���κ� ���� üũ �÷���. ������� ���� ������ �����ϸ� ��� false ��ȯ
			boolean flag = false;
			
			// ���� Ư�� �� ��ø ī��Ʈ
			int cur = 0, cnt = 0;
			for(int j=0; j<r; j++) {
				// ���� Ư���� Ȯ���� �� ������ ������ ī��Ʈ�� ����, �ٸ��� �ʱ�ȭ �� ī��Ʈ ����
				int curBit = bits[j] & (1<<i);
				if(curBit != cur) {
					cnt = 0; cur = curBit;
				}
				cnt++;
				// ���� ���� Ư���� ������ ����ŭ ��ø�� ���¶�� �ش� ������ ���� �˻� ���
				if(cnt >= k) {
					flag = true;
					break;
				}
			}
			// ���� �˻縦 ������� ���� ������ �ϳ��� ������ ��� false ��ȯ
			if(!flag) return false;
		}
		// ��� ������ ���� �˻� ���
		return true;
	}
	
	public static void bt(int start, int cnt) {
		// ���ݱ��� ������ �๰�� �ּ� ���� �๰���� �����Ѵٸ� ���� Ž���� �ʿ� ����
		if(cnt >= minAd) return;
		
		for(int i=start; i<r; i++) {
			// ���� ���� ���� ����
			int line = bits[i];
			// ��ǰ A�� �����Ͽ� �׽�Ʈ�� ����ߴٸ� �ٸ� ������ Ž���� �ʿ䰡 ����
			// �׷��� �ʴٸ� ��ǰ A ���� �� ���� ���� Ž��
			bits[i] = 0;
			if(testImpact(cnt)) {
				minAd = cnt;
				bits[i] = line;
				break;
			}
			bt(i+1, cnt+1);
			// ��ǰ B�� �����Ͽ� �׽�Ʈ�� ����ߴٸ� �ٸ� ������ Ž���� �ʿ䰡 ����
			// �׷��� �ʴٸ� ��ǰ B ���� �� ���� ���� Ž��
			bits[i] = ~0;
			if(testImpact(cnt)) {
				minAd = cnt;
				bits[i] = line;
				break;
			}
			bt(i+1, cnt+1);
			
			// ������ ���� ���·� ����
			bits[i] = line;
		}
	}
	
}
