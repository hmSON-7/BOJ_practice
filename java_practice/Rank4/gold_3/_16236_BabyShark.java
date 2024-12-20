package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _16236_BabyShark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 초기화
        int[] current = null; // 현재 상어의 위치를 저장할 배열
        int n = Integer.parseInt(br.readLine());
        int[][] space = new int[n][n]; // 맵. 순서대로 y축, x축
        for(int i=0; i<n; i++) {
            String[] fishStr = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                space[i][j] = Integer.parseInt(fishStr[j]);
                if(space[i][j] == 9) {
                    current = new int[]{i, j, 0}; // 상어의 시작 위치
                    space[i][j] = 0;
                }
            }
        }

        // 초기 설정
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 방향 설정. 순서 : 상, 좌, 우, 하
        int size = 2, move = 0, eatCount = 0; // 상어의 크기, 총 이동 거리, 상어가 먹은 물고기 수

        PriorityQueue<int []> q = new PriorityQueue<>((a, b) ->
                a[2] != b[2] ? Integer.compare(a[2], b[2]) : // 조건 1 : 거리차 비교
                        a[0] != b[0] ? Integer.compare(a[0], b[0]) : // 조건 2 : 상하 비교
                                Integer.compare(a[1], b[1]) // 조건 3 : 좌우 비교
        );

        // 알고리즘 시작
        while(true) {
            boolean[][] visit = new boolean[n][n]; // 구역 방문 여부를 저장
            // 현재 위치 기록
            q.add(new int[]{current[0], current[1], 0}); // y축, x축, 현재 위치로부터의 거리

            boolean eat = false; // 먹이를 먹었는 지 확인
            visit[current[0]][current[1]] = true; // 현재 위치 확인

            while(!q.isEmpty()) {
                current = q.remove();

                // 1. 조건 : 당장 먹을 수 있는 물고기인가?
                if (space[current[0]][current[1]] != 0 && space[current[0]][current[1]] < size) {
                    space[current[0]][current[1]] = 0; // 물고기 제거
                    eatCount++; // 먹은 물고기 카운트 증가
                    eat = true; // 먹은 물고기가 있음을 체크
                    move += current[2]; // 움직인 거리를 총 움직인 거리에 추가
                    break;
                }

                // 2. 이동할 수 있는 위치를 큐에 전부 저장
                for (int i=0; i<4; i++) {
                    int y = current[0] + direction[i][0]; // y축
                    int x = current[1] + direction[i][1]; // x축

                    if (y < 0 || x < 0 || x >= n || y >= n || visit[y][x] || space[y][x] > size)
                        continue; // 이동할 수 없거나 이미 이동했던 위치는 큐에 저장하지 않음

                    q.add(new int[]{y, x, current[2] + 1});
                    visit[y][x] = true;
                }
            }

            if(!eat) break; // 큐가 비워지는 동안 먹은 게 없다면 먹을 수 있는 물고기가 없다는 의미. 알고리즘 종료

            // 3. 상어가 자신의 크기 만큼의 물고기를 먹었다면?
            if(size == eatCount) {
                size++;
                eatCount = 0;
            }

            q.clear(); // 현재 큐에 남은 좌표들은 모두 다음 알고리즘에서 필요가 없으므로 제거
        }

        System.out.println(move);
    }
}
