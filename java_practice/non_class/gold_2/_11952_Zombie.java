package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11952_Zombie {
    public static void main(String[] args) throws IOException {
        // 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        int path = Integer.parseInt(st.nextToken());
        int zombies = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        // 방문 도시 및 도시 연결 정보
        long[] visited = new long[cities+1];
        Arrays.fill(visited, Long.MAX_VALUE);
        visited[1] = 0;
        List<List<Integer>> link = new ArrayList<>();
        for(int i=0; i<=cities; i++) {
            link.add(new ArrayList<>());
        }
        char[] cityStates = new char[cities+1];
        Arrays.fill(cityStates, 's');
        // 숙박시 금액
        st = new StringTokenizer(br.readLine());
        int safe = Integer.parseInt(st.nextToken());
        int danger = Integer.parseInt(st.nextToken());
        // 점령당한 도시 정보
        Queue<int[]> dangerousCity = new LinkedList<>();
        for(int i=0; i<zombies; i++) {
            int dead = Integer.parseInt(br.readLine());
            cityStates[dead] = 'x';
            dangerousCity.add(new int[]{dead, 0});
        }
        // 도시 연결 정보
        for(int i=0; i<path; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            link.get(city1).add(city2);
            link.get(city2).add(city1);
        }
        // 위험 도시 확인
        while(!dangerousCity.isEmpty()) {
            int[] city = dangerousCity.poll();
            int cityIdx = city[0];
            int currentRange = city[1];
            for (int c : link.get(cityIdx)) {
                if (cityStates[c] != 's') continue;
                cityStates[c] = 'd';
                if (currentRange + 1 < range) dangerousCity.add(new int[]{c, currentRange + 1});
            }
        }
        // 이동 단계
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingLong(a -> visited[a]));
        q.add(1);
        while(!q.isEmpty()) {
            int city = q.poll();
            if (city == cities) break;
            for (int c : link.get(city)) {
                if(cityStates[c] == 'x') continue;
                long nextCost = (c == cities)
                        ? visited[city]
                        : visited[city] + (cityStates[c] == 's' ? safe : danger);
                if (nextCost < visited[c]) {
                    visited[c] = nextCost;
                    q.add(c);
                }
            }
        }
        System.out.println(visited[cities]);
    }
}
