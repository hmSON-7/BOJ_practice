package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
* BOJ_21608: 상어 초등학교
교실의 크기 : n*n, 학생 수 : n^2, 각 학생별로 1번부터 n*2번까지 번호가 있음
(r, c) : 교실에서의 각 학생 위치
각 학생별로 좋아하는 학생이 4명씩 존재. 다음 규칙에 따라 학생의 자리 배정. 한 칸에는 한 명의 학생만.
이 문제에서 말하는 인접함은 1 맨해튼 거리. 즉 4방향 인접 칸이다.

자리 배정 규칙:
1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함
2. 1을 만족하는 칸이 여러 개이면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리 배정
3. 2를 만족하는 칸도 여러 개인 경우, 행 번호가 가장 작은 칸으로, 그러한 칸도 여러 개면 열 번호가 가장 작은 칸으로 배정
*/

public class _21608_SharkElementarySchool {
    static int n;
    static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0}, pt = {0, 1, 10, 100, 1000};
    static int[][] board;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // 교실 정보 초기화
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=1; i<=n*n; i++) map.put(i, new ArrayList<>());

        // 각 학생별 좋아하는 학생 정보 입력 후 자리 배치
        StringTokenizer st;
        for(int i=0; i<n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            // 해당 학생의 좋아하는 학생 정보 입력
            List<Integer> likes = map.get(idx);
            for(int j=0; j<4; j++) likes.add(Integer.parseInt(st.nextToken()));
            // 규칙에 따라 초기 배치는 반드시 (1, 1)임
            if(i==0) {
                board[1][1] = idx; continue;
            }
            // 학생 배치
            setIn(idx);
        }

        // 각 학생별 만족도 합계 출력
        System.out.println(getResult());
    }

    private static void setIn(int idx) {
        // 모든 빈 자리의 인접한 좋아하는 학생 수, 인접한 빈 자리 수를 기록하여 최적의 자리를 갱신
        int bestR = -1, bestC = -1, mostLikes = 0, mostEmpty = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 이미 학생이 앉은 자리는 패스
                if(board[i][j] > 0) continue;
                // 각 자리의 정보 반환
                int[] info = getCnt(i, j, idx);
                // 제일 처음 탐색한 빈 자리 정보 저장
                if(bestR == -1) {
                    bestR = i; bestC = j;
                    mostLikes = info[0]; mostEmpty = info[1];
                    continue;
                };
                // 규칙 1: 인접한 좋아하는 학생 수가 가장 많은 자리에 배치
                if(info[0] > mostLikes) {
                    bestR = i; bestC = j;
                    mostLikes = info[0]; mostEmpty = info[1];
                }
                // 규칙 2: 규칙 1에 해당하는 자리가 여러 개인 경우 인접한 빈 자리가 가장 많은 자리에 배치
                else if(info[0] == mostLikes && info[1] > mostEmpty) {
                    bestR = i; bestC = j;
                    mostEmpty = info[1];
                }
                // 규칙 3: 규칙 2에 해당하는 자리도 여러 개인 경우 인덱스상 우선순위(y, x)로 결정
            }
        }
        // 최적의 자리에 학생 배치
        board[bestR][bestC] = idx;
    }

    private static int[] getCnt(int y, int x, int idx) {
        // 지정된 자리의 인접한 자리를 탐색하며 좋아하는 학생과 빈 자리의 수를 기록 및 반환
        int likesCnt = 0, emptyCnt = 0;
        List<Integer> likes = map.get(idx);
        for(int i=0; i<4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
            int near = board[newY][newX];
            if(near == 0) emptyCnt++;
            else if(likes.contains(near)) likesCnt++;
        }
        return new int[]{likesCnt, emptyCnt};
    }

    private static int getLikesCnt(int y, int x, int idx) {
        // 지정된 자리의 인접한 자리를 탐색하며 좋아하는 학생의 수를 기록 및 반환
        int likesCnt = 0;
        List<Integer> likes = map.get(idx);
        for(int i=0; i<4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
            int near = board[newY][newX];
            if(likes.contains(near)) likesCnt++;
        }
        return likesCnt;
    }

    private static int getResult() {
        // 결과 반환 메소드. 각 자리의 만족도 점수 합산 후 반환
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int cnt = getLikesCnt(i, j, board[i][j]);
                res += pt[cnt];
            }
        }
        return res;
    }
}
