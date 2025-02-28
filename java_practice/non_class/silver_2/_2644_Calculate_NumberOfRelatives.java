package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2644_Calculate_NumberOfRelatives {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken());
        int rel = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<rel; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
            list.get(parent).add(child);
            list.get(child).add(parent);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(p1);
        dist[p1] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list.get(cur)) {
                if(dist[next] < dist[cur]+1) continue;
                if(next == p2) {
                    System.out.println(dist[cur]+1);
                    return;
                }
                dist[next] = dist[cur]+1;
                q.add(next);
            }
        }
        System.out.println(-1);
    }
}
