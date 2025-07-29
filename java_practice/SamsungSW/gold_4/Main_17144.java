package gold_4;

import java.io.*;
import java.util.StringTokenizer;

class Main_17144 {
    // 각각 맵의 크기, 턴 수, 클리너 y축 위치
    static int r, c, cmdCnt, cleaner;
    static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
    // 각각 기본 맵, 미세먼지 확산 맵
    static int[][] map, spread;
    public static void main(String[] args) throws Exception {
        init();
        while(cmdCnt-- > 0) {
            solve();
        }
        // 모든 미세먼지의 양을 더한 뒤 출력
        int sum = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int dust = map[i][j];
                if(dust > 0) sum += dust;
            }
        }
        System.out.println(sum);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맵 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cmdCnt = Integer.parseInt(st.nextToken());
        map = new int[r][c]; spread = new int[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                int dust = Integer.parseInt(st.nextToken());
                map[i][j] = dust;
                // 만약 현재 위치에 있는 것이 미세먼지가 아닌 공기청정기라면?
                if(dust == -1 && cleaner == 0) {
                    cleaner = i;
                    spread[i][0] = -1; spread[i+1][0] = -1;
                }
            }
        }
    }

    public static void solve() {
        // 1. 먼지 확산 단계. 현재 위치의 먼지량이 5 이상인 경우 확산.
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int dust = map[i][j];
                if(dust >= 5) spreadDust(i, j, dust);
            }
        }
        // 2. 먼지 확산 후 현재 위치에 변화를 적용
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int dust = spread[i][j];
                if(dust > 0) {
                    map[i][j] += dust;
                    spread[i][j] = 0;
                }
            }
        }
        // 3. 청소 단계
        clean();
    }

    // 먼지 확산 처리 메서드
    public static void spreadDust(int y, int x, int dust) {
        int curr = dust;
        // 확산되는 먼지의 양은 반드시 (기존 먼지의 양)/5
        int spreaded = dust / 5;
        for(int i=0; i<4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            // 옆칸이 벽이거나, 공기청정기인 경우 확산 불가
            if(!isIn(newY, newX) || spread[newY][newX] == -1) continue;
            // 확산 후 기존 먼지가 존재했던 위치의 먼지량을 확산된 양만큼 차감
            spread[newY][newX] += spreaded;
            curr -= spreaded;
        }
        // 현재 맵에도 확산 결과 반영
        map[y][x] = curr;
    }

    // 공기청정기 청소 단계 메서드
    // 공기 흐름의 역순으로 추적하며 먼지 이동 정보 갱신
    public static void clean() {
        // 공기청정기 상단
        for(int i=cleaner-1; i>0; i--) map[i][0] = map[i-1][0];
        for(int i=0; i<c-1; i++) map[0][i] = map[0][i+1];
        for(int i=0; i<cleaner; i++) map[i][c-1] = map[i+1][c-1];
        for(int i=c-1; i>1; i--) map[cleaner][i] = map[cleaner][i-1];
        map[cleaner][1] = 0;

        // 공기청정기 하단
        for(int i=cleaner+2; i<r-1; i++) map[i][0] = map[i+1][0];
        for(int i=0; i<c-1; i++) map[r-1][i] = map[r-1][i+1];
        for(int i=r-1; i>cleaner+1; i--) map[i][c-1] = map[i-1][c-1];
        for(int i=c-1; i>1; i--) map[cleaner+1][i] = map[cleaner+1][i-1];
        map[cleaner+1][1] = 0;
    }

    // 배열 범위 초과 방지 메서드
    public static boolean isIn(int y, int x) {
        return y >= 0 && x >= 0 && y < r && x < c;
    }
}