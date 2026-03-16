package silver_2;

import java.io.*;
import java.util.*;

public class Main_24480 {

    /*
     * BOJ_24480 : 알고리즘 수업 - 깊이 우선 탐색 2 (Silver_2)
     * 자료구조 및 알고리즘 : 그래프 탐색, 깊이 우선 탐색, 정렬
     *
     * [문제 요약]
     * - 정점 V개, 간선 E개인 무방향 그래프가 주어진다.
     * - 시작 정점 R에서 DFS를 수행한다.
     * - 인접 정점이 여러 개라면 "번호가 큰 정점부터" 방문한다.
     * - 각 정점의 방문 순서를 출력한다. (방문하지 못하면 0)
     *
     * [핵심 아이디어]
     * - DFS는 재귀(또는 스택)로 구현할 수 있고, 방문 순서를 기록하면 된다.
     * - “큰 번호 우선” 조건을 만족하려면 인접 리스트를 내림차순으로 유지해야 한다.
     * - TreeSet을 내림차순(ReverseOrder)으로 만들면, 삽입과 동시에 정렬 상태가 유지되어
     *   순회 시 자동으로 큰 번호부터 탐색된다.
     *
     * [구현 메모]
     * - graph[i]를 TreeSet(Collections.reverseOrder())로 생성해 내림차순 인접 정점을 유지한다.
     * - visited[i]에는 방문 순서를 저장하고, 0이면 미방문으로 처리한다.
     * - 시작 정점은 visited[start]에 먼저 방문 순서를 기록한 뒤 dfs(start)를 호출한다.
     * - dfs(idx)는 idx의 인접 정점을 큰 번호부터 순회하면서,
     *   아직 방문하지 않은 정점만 방문 처리 후 재귀 호출한다.
     *
     * [시간 복잡도]
     * - TreeSet 삽입: O(log deg) (간선 입력 시 정렬 유지 비용)
     * - DFS 순회: O(V + E)
     * - 전체적으로 입력 구성 비용을 포함하면 O(E log V) 수준
     */

    static int v, start, cnt = 1; // 카운트는 1부터 시작
    static TreeSet<Integer>[] graph; // 내림차순 정렬을 위해 TreeSet 사용(List 사용 후 내림차순 정렬해도 무관)
    static int[] visited; // 방문 순서 등록, 미방문시 0

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken()) - 1; // 0 - based

        visited = new int[v];
        graph = new TreeSet[v];
        for(int i=0; i<v; i++) {
            graph[i] = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬 적용
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
    }

    static void dfs(int idx) {
        for(int next : graph[idx]) {
            // visited[i] > 0 이면 이미 방문한 번호임
            if(visited[next] != 0) continue;
            visited[next] = cnt++;
            dfs(next);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        visited[start] = cnt++;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<v; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

}