package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _2493_Tower {
    static int n;
    static int[] line, res;
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 탑 정보 입력
        n = Integer.parseInt(br.readLine());
        // 탑 높이 정보 저장할 배열
        line = new int[n];
        // 측정 결과를 저장할 배열
        res = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        // 스택 대신 데크 사용
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        // 역순 순회
        // 매 순회마다 현재 빌딩보다 높이가 낮은 빌딩을 전부 스택에서 제외하고 결과 저장
        // 이후 스택에 해당 빌딩의 위치 및 높이 정보 추가
        for(int i=n-1; i>=0; i--) {
            int next = line[i];
            // 오른쪽 빌딩의 높이가 현재 빌딩보다 낮은 상황
            // 낮은 빌딩들을 전부 스택에서 제거하고 현재 빌딩의 인덱스를 결과로 저장
            while(!stack.isEmpty() && stack.peekLast()[1] < next) {
                int[] pop = stack.removeLast();
                res[pop[0]] = i+1;
            }
            // 현재 빌딩 정보 저장
            stack.addLast(new int[]{i, next});
        }
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}
