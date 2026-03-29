package silver_1;

import java.io.*;
import java.util.*;

public class Main_30892 {

    /*
     * BOJ_30892 : 상어 키우기 (Gold_2)
     * 자료구조 및 알고리즘 : 그리디, 정렬, 스택
     *
     * [문제 요약]
     * - 크기가 각각 다른 상어 N마리가 주어지고, 내 상어의 초기 크기 shark가 주어진다.
     * - 내 상어는 자신보다 작은 상어만 먹을 수 있으며, 먹으면 그만큼 크기가 증가한다.
     * - 특수 행동은 최대 K번 사용할 수 있고, 이때 지금까지 먹을 수 있었던 상어들 중 하나를 선택해 크기를 늘릴 수 있다.
     * - 가능한 한 최종 크기를 크게 만들었을 때의 값을 출력한다.
     *
     * [핵심 아이디어]
     * - 현재 먹을 수 있는 상어를 먼저 차례대로 확보해 두고,
     *   막히는 순간에만 그동안 확보한 상어들 중 큰 것부터 사용하는 것이 유리하다.
     * - 따라서 상어 크기를 오름차순 정렬한 뒤,
     *   지금 당장 먹을 수 있는 상어들은 스택에 쌓아 두고,
     *   다음 상어를 못 먹는 순간 스택의 top(가장 큰 상어)부터 꺼내 shark를 키운다.
     * - "막힐 때만", "가장 큰 것부터" 사용하는 그리디 전략이다.
     *
     * [구현 메모]
     * - arr를 오름차순 정렬하면, 현재 시점에서 먹을 수 있었던 상어들은 앞쪽 구간에 모인다.
     * - stack에는 지금까지 먹을 수 있었던 상어들을 순서대로 넣어두고,
     *   오름차순으로 들어가므로 top에는 가장 큰 값이 위치한다.
     * - while(top > 0 && k > 0 && shark <= arr[i]):
     *   - 현재 상어 arr[i]를 못 먹는 동안,
     *   - 스택에 쌓인 상어 중 가장 큰 것부터 꺼내 shark를 증가시킨다.
     * - 그래도 shark <= arr[i] 이거나 k == 0이면 더 진행 불가이므로 반복을 중단한다.
     * - 마지막에는 아직 사용하지 않은 스택 원소가 남아 있고 k가 남아 있다면,
     *   큰 것부터 추가로 사용해 최종 크기를 최대화한다.
     *
     * [시간 복잡도]
     * - 정렬: O(N log N)
     * - 스캔 + 스택 처리: O(N)
     * - 총: O(N log N)
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long shark = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] stack = new int[n];
        int top = 0;

        for(int i=0; i<n; i++) {
            // 현재 상어를 먹을 수 없으면, 지금까지 확보한 상어 중 가장 큰 것부터 사용
            while(top > 0 && k > 0 && shark <= arr[i]) {
                shark += stack[--top];
                k--;
            }

            // 더 이상 성장 수단이 없거나, 그래도 현재 상어를 못 먹으면 종료
            if(k == 0 || shark <= arr[i]) break;

            // 현재 상어는 지금 시점에서 먹을 수 있으므로 후보로 스택에 저장
            stack[top++] = arr[i];
        }

        // 남은 사용 횟수가 있다면 확보해둔 상어를 큰 것부터 추가 사용
        while(top > 0 && k > 0) {
            shark += stack[--top];
            k--;
        }

        System.out.println(shark);
    }

}