package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055_Robots_on_ConveyorBelt {
    static int n, len, k, start = 0, end;
    static int[] durability;
    static boolean[] on;
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solve());
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컨베이어 벨트 정보 및 가동 종료 조건 입력.
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        len = 2 * n;
        end = n-1;
        // 컨베이어 벨트 각 칸의 내구도 입력.
        durability = new int[len];
        on = new boolean[len];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++) durability[i] = Integer.parseInt(st.nextToken());
    }

    private static int solve() {
        // 각 턴과 내구도가 닳은 칸의 개수를 기록하여 brokenCnt가 k까지 도달하면 즉시 turnCnt를 반환.
        int turnCnt = 0, brokenCnt = 0;
        while(true) {
            // 단계 1: 벨트가 각 칸 위의 로봇과 함께 한 칸씩 회전. 끝에 도달한 로봇은 내림.
            turnCnt++;
            start = (start - 1 + len) % len;
            end = (end - 1 + len) % len;
            if(on[end]) on[end] = false;
            // 단계 2: 가장 먼저 벨트에 올라왔던 로봇부터, 앞 칸으로 이동할 수 있다면 이동. 끝에 도달한 로봇은 내림.
            for(int i=(end<start ? end+len-1 : end-1); i>start; i--) {
                int curr = i%len, next = (i+1)%len;
                if(on[curr] && durability[next] > 0 && !on[next]) {
                    on[curr] = false;
                    on[next] = true;
                    durability[next]--;
                    if(durability[next] == 0) {
                        brokenCnt++;
                        if(brokenCnt == k) return turnCnt;
                    }
                    if(next == end) on[next] = false;
                }
            }
            // 단계 3: 시작 위치의 내구도가 0이 아니라면 새 로봇을 올림.
            if(durability[start] > 0) {
                on[start] = true;
                durability[start]--;
                if(durability[start] == 0) {
                    brokenCnt++;
                    if(brokenCnt == k) return turnCnt;
                }
            }
            // 단계 4: 내구도가 0이 된 칸이 k 미만인 경우에만 다음 턴을 진행.
        }
    }
}
