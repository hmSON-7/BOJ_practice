package gold_5;

import java.io.*;
import java.util.*;

public class _14503_RobotVacuumCleaner {
    static int r, c; // 배열 크기
    static int y, x, d; // 로봇 정보 : 순서대로 로봇의 y축, x축, 초기 방향(순서대로 0: 북, 1: 동, 2: 남, 3: 서)
    static char[][] board;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상기한 방향 정보
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        // 로봇 청소기 초기화
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 배열 내부 정보 입력
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
    }

    private static void solve() {
        /*
        배열 내 정보를 다음과 같이 규정
        '0' : 청소되지 않은 구역
        '1' : 벽. 즉 통과 불가능한 구역
        '2' : 청소가 끝난 구역. 지나가더라도 카운트하지 않음
        */

        int cnt = 0;
        while(true) {
            // 현재 위치가 청소되지 않았으므로 해당 위치를 청소하고 카운트
            if(board[y][x] == '0') {
                board[y][x] = '2';
                cnt++;
            }

            // 현재 위치 주변에 청소되지 않은 빈 칸이 존재하는지 반시계 방향 탐색
            // 탐색용 플래그 변수. false: 빈 칸 없음, true: 빈 칸 존재하므로 루프 지속
            boolean flag = false;
            // 4방향 반시계 방향 탐색
            for(int i=d+3; i>=d; i--) {
                int[] dir = directions[i%4];
                int newY = y + dir[0];
                int newX = x + dir[1];
                if(board[newY][newX] != '0') continue;
                flag = true;
                y = newY; x = newX; d = i%4;
                break;
            }
            if(flag) continue;

            // 주변에 청소되지 않은 빈 칸이 없어 1칸 후진
            // 이번엔 플래그를 벽 탐지용으로 사용. true: 빈 칸이 존재, false: 벽에 부딪힘 -> 루프 종료
            int[] reverse = directions[(d+2)%4];
            int newY = y + reverse[0];
            int newX = x + reverse[1];
            char next = board[newY][newX];
            if(next == '1') break;
            y = newY; x = newX;
        }

        System.out.println(cnt);
    }
}
