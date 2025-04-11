package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16139_Human_Computer_Interaction {
    // 전형적인 누적 합 풀이 방식으로 코드를 작성할 경우 최대 200,000자의 문자열과 최대 200,000회의 쿼리를 처리할 때 시간 초과 발생
    // 따라서 메모리를 크게 사용하더라도 각 쿼리에 대한 처리 과정을 최소하하기 위해 DP 방식으로 쿼리 결과를 정리한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[][] dp = new int[26][str.length()+1];
        for(int i=1; i<=str.length(); i++) {
            char c = str.charAt(i-1);
            for(int j=0; j<26; j++) {
                dp[j][i] = dp[j][i-1] + (c-'a' == j ? 1 : 0);
            }
        }
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int al = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[al][end+1] - dp[al][start]).append("\n");
        }
        System.out.println(sb);
    }
}
