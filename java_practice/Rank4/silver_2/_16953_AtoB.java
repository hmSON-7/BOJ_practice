package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16953_AtoB {
    static int start, end;
    static Queue<int[]> q = new LinkedList<>();
    static HashSet<Integer> visit = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        q.add(new int[]{end, 1});
        visit.add(end);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int count = cur[1];
            if (num == start) return count;

            if (num % 2 == 0 && !visit.contains(num / 2)) {
                q.add(new int[]{num / 2, count + 1});
                visit.add(num / 2);
            }
            if (num % 10 == 1) {
                int next = (num - 1) / 10;
                if (!visit.contains(next)) {
                    q.add(new int[]{next, count + 1});
                    visit.add(next);
                }
            }
        }
        return -1;
    }
}
