package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12738 {
	
	// BOJ_12015 : ���� �� �����ϴ� �κ� ���� 2��  ������ Ǯ�̷� ���� ����
	
	static int[] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// ���� ����Ʈ ����� ���� ����
		int curSize = 0;
		// ���Ҹ� �����ϴ� �迭�� �ƴ�, ���� �κ� ������ ����� �迭��
		memo = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			// ���� ����Ʈ�� �ƹ��͵� ���ٸ� -> ��� ������ ī��Ʈ, ����Ʈ 0��°�� �� �� �Է�
			if(curSize == 0) {
				curSize++;
				memo[0] = next;
				continue;
			}
			// �̺� Ž������ �� ���� �Էµ� �� �ִ� �ε��� ��ȯ
			int res =binarySearch(next, curSize);
			// ���� ����Ʈ�� �ڿ� �� ���� �߰��ؾ� �Ѵٸ� ������ ī��Ʈ
			if(res == curSize) curSize++;
			// ����� ������� �̺� Ž������ ã�� �ε��� ��ġ�� �� �� �Է�
			memo[res] = next;
		}
		
		System.out.println(curSize);
	}
	
	static int binarySearch(int x, int size) {
		// ans : ��ȯ�ϰ��� �ϴ� ��� �ε���, �ʱⰪ�� size�� ����
		int left = 0, right = size, ans = size;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			// ���� 1 : �����Ϸ��� ������ �۴ٸ�, �� ��ġ���� ������ �� ����
			// ���� 2 : �����Ϸ��� ������ ũ�ٸ�, �� ��ġ�� ���Ե� ���ɼ��� ����
			// ���� 3 : �����Ϸ��� ���� �����ϴٸ� ��ȭ ����. ��� Ž�� ����
			if(memo[mid] < x) {
				left = mid + 1;
			} else if(memo[mid] > x){
				ans = mid;
				right = mid - 1;
			} else {
				return mid;
			}
		}
		
		return ans;
	}

}
