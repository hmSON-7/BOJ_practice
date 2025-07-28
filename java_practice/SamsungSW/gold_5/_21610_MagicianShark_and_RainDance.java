package gold_5;

import java.io.*;
import java.util.*;

public class _21610_MagicianShark_and_RainDance {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, dir, dist;
    static int[][] board;
    static boolean[][] cloud;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1}, dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        init();
        // 각 명령에 따른 절차 진행
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken()) - 1;
            dist = Integer.parseInt(st.nextToken());
            move();
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void init() throws Exception {
        // 보드 크기 및 명령어 횟수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 각 칸의 물의 양 입력
        board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기 비구름 위치 설정
        cloud = new boolean[n][n];
        cloud[n-2][0] = true;
        cloud[n-2][1] = true;
        cloud[n-1][0] = true;
        cloud[n-1][1] = true;
    }

    private static void move() {
        // 현재 구름의 위치 확인
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(cloud[i][j]) {
                    q.add(new int[]{i, j});
                    cloud[i][j] = false;
                }
            }
        }
        // 구름을 새 위치로 이동
        while(!q.isEmpty()) {
            // 각 칸의 구름 이동
            int[] dest = q.poll();
            int y = (dest[0] + (dy[dir] * dist) + (n * dist)) % n;
            int x = (dest[1] + (dx[dir] * dist) + (n * dist)) % n;
            cloud[y][x] = true;
            // 비 내리기
            board[y][x]++;
        }
        // 현재 비를 내린 각 칸의 물 복사 버그 실행
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(cloud[i][j]) board[i][j] = copyWater(i, j);
            }
        }
        // 새 구름 생성
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(cloud[i][j]) {
                    cloud[i][j] = false;
                    continue;
                }
                if(board[i][j] >= 2) {
                    cloud[i][j] = true;
                    board[i][j] -= 2;
                }
            }
        }
    }

    private static int copyWater(int y, int x) {
        // 지정된 위치의 현재 물의 양
        int curr = board[y][x];

        // 주변 대각선 방향의 인접한 칸에 물이 있으면 카운트
        int cnt = 0;
        for(int i=1; i<8; i+=2) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
            if(board[newY][newX] > 0) cnt++;
        }

        // 카운트만큼 물 복사 실행
        return curr + cnt;
    }
}
