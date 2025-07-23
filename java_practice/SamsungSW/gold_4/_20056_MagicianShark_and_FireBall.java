package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _20056_MagicianShark_and_FireBall {
    static int n, fbCnt, cmdCnt;
    static FireBall[][] map;
    static Queue<FireBall> q = new ArrayDeque<>();
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}, dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        init();
        for(int i=0; i<cmdCnt; i++) executeCmd();
        System.out.println(getMassSum());
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기본 정보 입력(맵 크기, 파이어볼 수, 이동 명령 수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        fbCnt = Integer.parseInt(st.nextToken());
        cmdCnt = Integer.parseInt(st.nextToken());
        map = new FireBall[n][n];

        // 파이어볼 정보 입력 및 등록
        for(int i=0; i<fbCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            q.add(new FireBall(y, x, mass, dir, dist));
        }
    }

    private static void executeCmd() {
        // 파이어볼 전체 이동
        while(!q.isEmpty()) {
            FireBall fb = q.poll();
            int newY = (fb.y + (dy[fb.dir] * fb.dist) + (n * fb.dist)) % n;
            int newX = (fb.x + (dx[fb.dir] * fb.dist) + (n * fb.dist)) % n;
            // 이동한 위치에 다른 파이어볼이 없으면 그대로 배치
            if(map[newY][newX] == null) {
                fb.y = newY; fb.x = newX;
                map[newY][newX] = fb;
            }
            // 이동한 위치에 이미 다른 파이어볼이 도착한 상태라면 융합
            else {
                FireBall curr = map[newY][newX];
                curr.fuse(fb.mass, fb.dir, fb.dist);
            }
        }
        // 배열 전체를 돌면서 파이어볼 탐색
        // 파이어볼이 1개면 다시 큐에 등록
        // 파이어볼이 2개 이상이면 융합/분열 후 각각 큐에 등록
        // 등록 후 배열 내 해당 인덱스는 다시 null로 비워둘 것
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                FireBall curr = map[i][j];
                if(curr == null) continue;
                if(curr.cnt == 1) {
                    q.add(curr);
                    map[i][j] = null;
                    continue;
                }
                int newMass = curr.mass / 5;
                map[i][j] = null;
                if(newMass == 0) continue;
                int newDist = curr.dist / curr.cnt;
                for(int k=curr.xFlag; k<8; k+=2) {
                    q.add(new FireBall(i, j, newMass, k, newDist));
                }
            }
        }
    }

    private static int getMassSum() {
        int sum = 0;
        while(!q.isEmpty()) {
            FireBall fb = q.poll();
            sum += fb.mass;
        }
        return sum;
    }

    static class FireBall {
        int y, x, mass, dir, dist, cnt, xFlag;

        public FireBall(int y, int x, int mass, int dir, int dist) {
            this.y = y;
            this.x = x;
            this.mass = mass;
            this.dir = dir;
            this.dist = dist;
            this.cnt = 1;
            this.xFlag = 0;
        }

        public void fuse(int mass, int dir, int dist) {
            this.mass += mass;
            this.dist += dist;
            this.cnt++;
            if(this.dir % 2 != dir % 2) xFlag = 1;
        }
    }
}
