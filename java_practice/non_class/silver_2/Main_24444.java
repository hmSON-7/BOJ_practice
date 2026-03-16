package silver_2;

import java.io.*;
import java.util.*;

public class Main_24444 {

    /*
     * BOJ_24444 : 알고리즘 수업 - 너비 우선 탐색 1 (Silver_2)
     * 자료구조 및 알고리즘 : BFS, 정렬
     *
     * [문제 요약]
     * - 정점 V개, 간선 E개인 무방향 그래프가 주어진다.
     * - 시작 정점 R에서 BFS를 수행한다.
     * - 인접 정점이 여러 개라면 "번호가 작은 정점부터" 방문한다.
     * - 각 정점의 방문 순서를 출력한다. (방문하지 못하면 0)
     *
     * [핵심 아이디어]
     * - 최단거리 목적이 아니라 “탐색 순서” 기록이므로 일반 BFS 그대로 진행하면 된다.
     * - “작은 번호 우선” 조건을 만족하려면 인접 리스트를 오름차순으로 순회해야 한다.
     * - TreeSet을 사용하면 삽입과 동시에 오름차순 정렬이 유지되어, 순회 시 자동으로 작은 번호부터 처리된다.
     *
     * [구현 메모]
     * - graph[i]를 TreeSet으로 두어 인접 정점을 오름차순으로 유지한다.
     * - visited[i]에는 방문 순서를 저장하고, 0이면 미방문이다.
     * - 큐에 시작 정점을 넣고 visited[start]에 1부터 방문 순서를 부여한다.
     * - BFS에서 현재 정점을 poll한 뒤, 인접 정점을 오름차순으로 보며
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
            // 오름차순이므로 별개의 정렬 조건을 지정하지 않음
            graph[i] = new TreeSet<>();
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