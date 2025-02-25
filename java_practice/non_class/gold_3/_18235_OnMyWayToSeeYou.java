package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18235_OnMyWayToSeeYou {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int five = Integer.parseInt(st.nextToken());
        int six = Integer.parseInt(st.nextToken());
        if ((six-five) % 2 == 1) {
            System.out.println(-1);
            return;
        }
        int dist = 1;
        int day = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(five);
        q.add(six);
        while (!q.isEmpty()) {
            day++;
            int size = q.size();
            boolean[] visited = new boolean[n+1];
            while (size-- > 0) {
                int cur = q.poll();
                int next = cur + dist;
                if (next <= n) {
                    if (visited[next]) {
                        System.out.println(day);
                        return;
                    }
                    visited[next] = true;
                    q.add(next);
                }
                next = cur - dist;
                if (next > 0) {
                    if (visited[next]) {
                        System.out.println(day);
                        return;
                    }
                    visited[next] = true;
                    q.add(next);
                }
            }
            dist *= 2;
        }
        System.out.println(-1);
    }
}
