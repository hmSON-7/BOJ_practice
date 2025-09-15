package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] wires = new int[n][2];
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽 전봇대에 걸린 위치 기준으로 정렬
        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));
        
        int max = 0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            // 이미 설치된 전선들의 오른쪽에 걸린 높이를 비교하여 교차 여부 확인
            // 교차되지 않은 전선 개수만큼 카운트
            for(int j=0; j<i; j++) {
                if(wires[i][1] > wires[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        
        // 출력해야 하는 값은 잘라야 하는 전선의 수
        System.out.println(n - max);
    }
	
}
