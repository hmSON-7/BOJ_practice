package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
	
	// ���峭 ���� ��ư�� ������ ��Ʈ��
	static int bit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		int err = Integer.parseInt(br.readLine());
		
		if(err > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<err; i++) {
				int errNum = Integer.parseInt(st.nextToken());
				bit |= 1 << errNum;
			}
		}
		
		// ���ϴ� ä�� ��ȣ�� 100�� ��� ��ư�� ���� �ʿ䰡 ����. ��� ����
		if(target == 100) {
			System.out.println(0);
			System.exit(0);
		}
		
		// ���ϴ� ä�η� +/- ��ư���θ� �̵��ϴ� ����� ��ư ������ Ƚ���� �̸� ���
		int ans = Math.abs(target - 100);
		
		// ���ڷθ� �Է��� �� �ִ� �ٸ� ������ ������ �ϴ� ��ư �� + �� ��ü�� �Է��ϱ� ���� ������ �ϴ� ��ư ���� ����
		// ���� ��ư ������ Ƚ���� �ּҰ��� ����
		for(int i=0; i<999_999; i++) {
			int cnt = check(i);
			if(cnt > 0) {
				ans = Math.min(ans,  Math.abs(target - i) + cnt);
			}
		}
		
		System.out.println(ans);
	}
	
	static int check(int x) {
		if(x == 0) return ((bit & 1) == 1 ? 0 : 1);
		
		int cnt = 0;
		while(x > 0) {
			if((bit & 1<<(x%10)) != 0) return 0;
			cnt++;
			x /= 10;
		}
		
		return cnt;
	}

}
