package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1939_WeightLimitation {
    static int n, m, start, end;
    static List<HashMap<Integer, Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            list.add(new HashMap<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> map = list.get(y);
            map.put(x, Math.max(map.getOrDefault(x, 0), w));
            map = list.get(x);
            map.put(y, Math.max(map.getOrDefault(y, 0), w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
    }

    private static void solve() {
        boolean[] visited = new boolean[n];
        int[] weight = new int[n];
        Arrays.fill(weight, 0);
        weight[start] = 1_000_000_001;
        PriorityQueue<int []> q = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        q.add(new int[]{start, weight[start]});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0], value = cur[1];
            if(visited[idx]) continue;
            visited[idx] = true;
            if(idx == end) break;
            HashMap<Integer, Integer> map = list.get(idx);
            for(int key : map.keySet()) {
                int bridge = map.get(key);
                if(visited[key]) continue;
                int w = Math.min(value, bridge);
                if(w > weight[key]) {
                    weight[key] = w;
                    q.add(new int[]{key, w});
                }
            }
        }
        System.out.println(weight[end]);
    }
}
