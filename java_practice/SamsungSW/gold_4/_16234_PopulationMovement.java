package gold_4;

import java.io.*;
import java.util.*;

class Main {
    static int n, left, right, dayCnt = 0, total;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    static List<int[]> uniteList = new ArrayList<>();
    static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void solve() {
        // 매 루프마다 일수를 기록
        // 인구 이동이 단 한 번도 없었던 날에 루프 종료 후 일수 경과 출력
        while(true) {
            boolean searchRes = search();
            if(!searchRes) break;
            dayCnt++;
        }
        System.out.println(dayCnt);
    }

    public static boolean search() {
        // 매일 인구 이동 여부 탐색
        visited = new boolean[n][n];
        boolean flag = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;
                q.add(new int[]{i, j});
                uniteList.clear();
                bfs();
                if(!flag && uniteList.size() > 1) flag = true;
                for(int[] p : uniteList) map[p[0]][p[1]] = total / uniteList.size();
            }
        }

        return flag;
    }

    public static void bfs() {
        // 인구 이동에 열려있는 지역인지 인구 차이를 이용해 탐색
        total = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            uniteList.add(curr);
            int y = curr[0], x = curr[1];
            total += map[y][x];
            for(int i=0; i<4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if(!isIn(newY, newX) || visited[newY][newX]) continue;
                int diff = Math.abs(map[y][x] - map[newY][newX]);
                if(diff >= left && diff <= right) {
                    visited[newY][newX] = true;
                    q.add(new int[]{newY, newX});
                }
            }
        }
    }

    public static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }
}
