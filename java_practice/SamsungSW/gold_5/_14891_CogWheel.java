package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14891_CogWheel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, wheelNum, dir;
    static boolean[] visited;
    static boolean[][] wheels = new boolean[4][8];
    static int[] left = {6, 6, 6, 6}, right = {2, 2, 2, 2};
    public static void main(String[] args) throws Exception {
        // 초기 설정
        init();
        // 회전
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            // wheelNum : 회전시킬 톱니바퀴 번호
            wheelNum = Integer.parseInt(st.nextToken()) - 1;
            // dir : 회전 방향. 연산 과정에서의 편의를 위해 임의로 반대 설정
            dir = Integer.parseInt(st.nextToken()) * -1;
            visited = new boolean[4];
            visited[wheelNum] = true;
            spin(wheelNum, dir);
        }
        // 12시 방향 톱니 점수 합산 후 출력
        System.out.println(getSum());
    }

    private static void init() throws Exception {
        // 초기 톱니바퀴 정보 입력
        // false는 N극, true는 S극
        for(int i=0; i<4; i++) {
            String line = br.readLine();
            for(int j=0; j<8; j++) {
                wheels[i][j] = line.charAt(j) == '1';
            }
        }
        // 회전 횟수 입력
        t = Integer.parseInt(br.readLine());
    }

    private static void spin(int n, int d) {
        // 항상 left 배열과 right 배열에 각 톱니바퀴의 9시 방향, 3시 방향 인덱스를 저장
        // 위의 좌/우측 인덱스를 기반으로 각 톱니의 극 정보를 가져옴
        int leftIdx = left[n], rightIdx = right[n];
        boolean leftTooth = wheels[n][leftIdx], rightTooth = wheels[n][rightIdx];
        // 주어진 방향에 따라 톱니바퀴 회전. 시계방향 회전시 인덱스가 음수가 되는 것을 방지
        left[n] = (left[n] + d + 8) % 8;
        right[n] = (right[n] + d + 8) % 8;

        // 왼쪽에 아직 돌지 않은 톱니바퀴가 존재할 경우
        if(n-1 >= 0 && !visited[n-1]) {
            // 맞닿은 톱니의 극이 서로 다른 지 확인. 다르면 좌측 톱니바퀴의 역회전 진행
            int nextLeft = right[n-1];
            visited[n-1] = true;
            if(wheels[n-1][nextLeft] != leftTooth) spin(n-1, -(d));
        }
        // 오른쪽에 아직 돌지 않은 톱니바퀴가 존재할 경우
        if(n+1 < 4 && !visited[n+1]) {
            // 맞닿은 톱니의 극이 서로 다른 지 확인. 다르면 우측 톱니바퀴의 역회전 진행
            int nextRight = left[n+1];
            visited[n+1] = true;
            if(wheels[n+1][nextRight] != rightTooth) spin(n+1, -(d));
        }
    }

    private static int getSum() {
        // 각 톱니바퀴의 12시 방향 톱니의 극 정보에 따라 점수 합산
        int sum = 0;
        for(int i=0; i<4; i++) {
            int top = (left[i] + 2) % 8;
            boolean tooth = wheels[i][top];
            if(tooth) sum += (int) Math.pow(2, i);
        }
        return sum;
    }
}
