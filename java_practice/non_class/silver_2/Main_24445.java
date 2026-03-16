package silver_2;

import java.io.*;
import java.util.*;

public class Main_24445 {

    /*
     * BOJ_24445 : 알고리즘 수업 - 너비 우선 탐색 2 (Silver_2)
     * 자료구조 및 알고리즘 : 그래프 탐색, 너비 우선 탐색, 정렬
     *
     * [문제 요약]
     * - 정점 V개, 간선 E개인 무방향 그래프가 주어진다.
     * - 시작 정점 R에서 BFS를 수행한다.
     * - 인접 정점이 여러 개라면 "번호가 큰 정점부터" 방문한다.
     * - 각 정점의 방문 순서를 출력한다. (방문하지 못하면 0)
     *
     * [핵심 아이디어]
     * - BFS는 큐를 이용해 레벨(거리) 순서대로 탐색한다.
     * - “큰 번호 우선” 조건을 만족하려면 인접 정점을 내림차순으로 순회해야 한다.
     * - TreeSet을 내림차순(ReverseOrder)으로 생성하면, 삽입과 동시에 정렬 상태가 유지되어
     *   순회 시 자동으로 큰 번호부터 처리된다.
     *
     * [구현 메모]
     * - graph[i] = new TreeSet<>(Collections.reverseOrder()) 로 인접 리스트를 내림차순 유지.
     * - visited[i]는 방문 순서를 저장하며, 0이면 미방문이다.
     * - 시작 정점을 큐에 넣고 방문 순서를 1부터 부여한다.
     * - BFS 루프에서 poll 후, 인접 정점을 내림차순으로 보며
     *   아직 방문하지 않은 정점만 방문 처리 후 큐에 넣는다.
     *
     * [시간 복잡도]
     * - TreeSet 삽입: O(log deg) (간선 입력 시 정렬 유지 비용)
     * - BFS 순회: O(V + E)
     * - 전체적으로 입력 구성 비용을 포함하면 O(E log V) 수준
     */

    static int v, start, cnt = 1; // 방문 순서는 1부터 시작
    static TreeSet<Integer>[] graph; // 정렬된 인접 리스트
    static int[] visited; // 방문 순서 저장, 미방문은 0

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken()) - 1;

        visited = new int[v];
        graph = new TreeSet[v];
        for(int i=0; i<v; i++) {
            // 내림차순 정렬 적용
            graph[i] = new TreeSet<>(Collections.reverseOrder());
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = cnt++;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph[cur]) {
                if(visited[next] != 0) continue;
                visited[next] = cnt++;
                q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<v; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

}