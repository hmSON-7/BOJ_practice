package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
	
	// 고장난 숫자 버튼을 저장할 비트열
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
		
		// 원하는 채널 번호가 100인 경우 버튼을 누를 필요가 없음. 즉시 종료
		if(target == 100) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 원하는 채널로 +/- 버튼으로만 이동하는 경우의 버튼 누르는 횟수를 미리 등록
		int ans = Math.abs(target - 100);
		
		// 숫자로만 입력할 수 있는 다른 값까지 눌러야 하는 버튼 수 + 값 자체를 입력하기 위해 눌러야 하는 버튼 수를 더함
		// 이후 버튼 누르는 횟수의 최소값을 갱신
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
