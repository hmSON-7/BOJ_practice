package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15961_RotatingSushi {
    static int n, d, kind, ticket;
    static int[] belt, sushi;
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solve());
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 각각 벨트 길이, 초밥 종류, 연속으로 먹어야 하는 초밥 수, 무료 제공 티켓 입력
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        kind = Integer.parseInt(st.nextToken());
        ticket = Integer.parseInt(st.nextToken());
        // 벨트 위에 초밥 배치
        belt = new int[n];
        for(int i=0; i<n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        // 각 초밥의 개수를 추적할 고정 배열
        sushi = new int[d+1];
    }

    public static int solve() {
        // 슬라이딩 윈도우 초기 설정
        // 리스트에 추가할 초밥의 개수를 카운트, 새로 들어오는 경우 초기 카운트를 증가시킴
        int start = 0, end = kind-1, maxCnt = 0;
        for(int i=start; i<=end; i++) {
            int curr = belt[i];
            if(sushi[curr] == 0) maxCnt++;
            sushi[curr]++;
        }
        // 각 루프에서의 초밥 종류 수를 카운트
        int currCnt = maxCnt;
        // 추가로 리스트에 티켓에 적힌 초밥이 없으면 추가 카운트
        if(sushi[ticket] == 0) maxCnt++;
        if(maxCnt == kind+1) return maxCnt;

        // 슬라이딩 윈도우 시작, start가 n이 되기 직전까지 루프 실행
        for(start = 1; start < n; start++) {
            end = (end+1)%n;
            // 각각 리스트에서 제거할 초밥, 추가할 초밥의 종류;
            int prev = belt[start-1], next = belt[end];
            // 리스트에서 빠질 초밥과 새로 추가될 초밥이 다른 종류인 경우에 대한 처리
            if(prev != next) {
                sushi[prev]--;
                if(sushi[prev] == 0) currCnt--;
                if(sushi[next] == 0) currCnt++;
                sushi[next]++;
            }
            if(currCnt < maxCnt) continue;
            // 만약 티켓에 적힌 초밥이 없다면 카운트 추가
            int bonus = 0;
            if(sushi[ticket] == 0) bonus++;
            // 최대값 갱신
            maxCnt = currCnt + bonus;
            if(maxCnt == kind+1) break;
        }
        return maxCnt;
    }
}
