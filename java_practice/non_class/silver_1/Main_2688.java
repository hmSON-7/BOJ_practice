package silver_1;

import java.io.*;
import java.util.*;

public class Main_2688 {

    /*
     * BOJ_2688 : 줄어들지 않아 (Silver_1)
     * 자료구조 및 알고리즘 : DP
     *
     * [문제 요약]
     * - 길이가 N인 수 중에서, 각 자리수가 왼쪽에서 오른쪽으로 갈수록 줄어들지 않는(비내림) 수의 개수를 구한다.
     *   예) 00119, 12344는 가능 / 321, 210은 불가능
     * - N은 최대 64이고, 테스트케이스가 여러 개 주어진다.
     *
     * [핵심 아이디어]
     * - 자리수를 왼쪽에서 오른쪽으로 붙일 때,
     *   이전 자리의 숫자보다 작은 숫자는 붙일 수 없다.
     * - dp[i][j]를 "길이 i이고 마지막 자리가 j인 비내림 수의 개수"로 두면 점화식이 성립한다.
     *   - 마지막 자리가 j인 길이 i 수는,
     *     길이 i-1에서 마지막 자리가 0..j인 것들 뒤에 j를 붙인 경우의 수 합이다.
     * - 누적합 형태로 정리하면:
     *   dp[i][j] = dp[i][j-1] + dp[i-1][j]
     *   (길이 i에서 마지막 자리가 j 이하인 개수 + 길이 i-1에서 마지막이 j인 개수)
     * - 매 테스트케이스마다 DP를 새로 만들지 않고,
     *   N=64까지 미리 채워두면 입력이 많아도 즉시 답을 낼 수 있다.
     *
     * [구현 메모]
     * - dp[i][0]은 항상 1 (전부 0으로만 이루어진 경우 한 가지)
     * - dp[i][10]은 길이 i에서 가능한 전체 개수를 저장하는 용도(0~9 합)
     *   - dp[1][10] = 10
     *   - i>=2부터는 dp[i][j]를 채우면서 dp[i][10]에 누적한다.
     * - long을 사용하는 이유: N이 커질수록 경우의 수가 매우 커진다.
     *
     * [시간 복잡도]
     * - 전처리: O(64 * 10)
     * - 각 테스트케이스 답 출력: O(1)
     */

    public static void main(String[] args) throws Exception {
        long[][] dp = new long[65][11];
        Arrays.fill(dp[1], 1);
        dp[1][10] = 10;

        for(int i=2; i<=64; i++) {
            dp[i][0] = 1;
            dp[i][10] = 1;
            for(int j=1; j<=9; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][10] += dp[i][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int id = Integer.parseInt(br.readLine());
            sb.append(dp[id][10]).append("\n");
        }
        System.out.println(sb);
    }

}