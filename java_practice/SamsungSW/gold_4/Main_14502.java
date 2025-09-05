package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502 {
    static int r, c, areaCnt = -3, maxSafeArea = 0;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> emptiesList = new ArrayList<>();
    static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
    public static void main(String[] args) throws Exception {
        init(); comb(0, 0);
        System.out.println(maxSafeArea);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                char ch = st.nextToken().charAt(0);
                map[i][j] = ch;
                // 빈 공간 좌표를 통로 리스트에 등록
                if(ch == '0') {
                    areaCnt++;
                    emptiesList.add(new int[]{i, j});
                }
                // 바이러스 좌표를 바이러스 리스트에 등록
                else if(ch == '2') virusList.add(new int[]{i, j});
            }
        }
    }

    // 설치할 벽 3개의 위치를 조합으로 지정
    public static void comb(int idx, int cnt) {
    	// 벽 3개가 설치되면 바이러스 확산 시작
        if(cnt == 3) {
            bfs(); return;
        }

        for(int i=idx; i<emptiesList.size(); i++) {
            int[] emptyArea = emptiesList.get(i);
            // 벽 설치 및 철거
            map[emptyArea[0]][emptyArea[1]] = '1';
            comb(i+1, cnt+1);
            map[emptyArea[0]][emptyArea[1]] = '0';
        }
    }

    public static void bfs() {
        visited = new boolean[r][c];
        Queue<int[]> q = new ArrayDeque<>();
       
        // 바이러스 초기 위치를 큐에 등록
        for(int[] v : virusList) {
            q.add(v);
            visited[v[0]][v[1]] = true;
        }
        int safeCnt = areaCnt;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int newY = cur[0] + dy[i];
                int newX = cur[1] + dx[i];
                if(!isIn(newY, newX) || map[newY][newX] == '1' || visited[newY][newX]) continue;
                visited[newY][newX] = true;
                q.add(new int[]{newY, newX});
                safeCnt--;
            }
            if(safeCnt <= maxSafeArea) return;
        }

        // 바이러스 확산 종료 후 남아있는 오염되지 않은 공간의 수를 확인 후 최대갑 갱신
        maxSafeArea = safeCnt;
    }

    public static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < r && x < c;
    }
}
