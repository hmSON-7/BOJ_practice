package silver_1;

import java.io.*;
import java.util.*;

public class Main_1890 {

    /*
     * BOJ_1890 : 점프 (Silver_1)
     * 자료구조 및 알고리즘 : DP
     *
     * [문제 요약]
     * - N×N 격자에서 (0,0)에서 시작해 (N-1,N-1)까지 이동하는 경우의 수를 구한다.
     * - 각 칸의 숫자만큼 오른쪽 또는 아래로만 점프할 수 있다.
     * - 도착 칸은 값이 0이며, 정확히 도착 칸에 도달하는 경우만 센다.
     *
     * [핵심 아이디어]
     * - 시작점에서 앞으로 경우의 수를 전파해도 되지만,
     *   이 코드는 반대로 도착 지점에서부터 거꾸로 채우는 DP를 사용했다.
     * - dp[i][j] = (i, j)에서 출발했을 때 도착점까지 갈 수 있는 경우의 수
     * - 어떤 칸 (i, j)에서 점프 길이가 x라면,
     *   이동 가능한 칸은 (i+x, j), (i, j+x) 두 곳뿐이다.
     * - 따라서 그 두 칸이 격자 안에 있다면,
     *   dp[i][j] = dp[i+x][j] + dp[i][j+x]
     *   형태로 점화식을 세울 수 있다.
     *
     * [구현 메모]
     * - 도착 지점 자체는 "도착한 상태" 1가지로 보기 때문에 dp[n-1][n-1] = 1로 시작한다.
     * - 마지막 행 / 마지막 열은 한 방향으로만 이동 가능하므로 먼저 따로 채운다.
     * - 이후 나머지 칸은 오른쪽 아래에서 왼쪽 위 방향으로 채우면,
     *   참조해야 하는 값(dp[i+x][j], dp[i][j+x])이 이미 계산되어 있다.
     * - 경우의 수가 커질 수 있으므로 dp는 long을 사용한다.
     *
     * [시간 복잡도]
     * - 모든 칸을 한 번씩 확인하므로 O(N^2)
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][n];
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착 지점에서 도착 지점까지 가는 경우의 수는 1
        dp[n-1][n-1] = 1;

        // 마지막 행 / 마지막 열은 한 방향으로만 이동 가능하므로 먼저 처리
        for(int i=n-2; i>=0; i--) {
            if(i + map[n-1][i] < n) dp[n-1][i] += dp[n-1][i+ map[n-1][i]];
            if(i + map[i][n-1] < n) dp[i][n-1] += dp[i+map[i][n-1]][n-1];
        }

        // 오른쪽 아래에서 왼쪽 위로 올라오며 경우의 수 누적
        for(int i=n-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(i + map[i][j] < n) dp[i][j] += dp[i+map[i][j]][j];
                if(j + map[i][j] < n) dp[i][j] += dp[i][j+map[i][j]];
            }
        }

        System.out.println(dp[0][0]);
    }

}