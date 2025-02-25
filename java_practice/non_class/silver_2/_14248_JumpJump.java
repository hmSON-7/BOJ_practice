package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248_JumpJump {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n];
        int[] rocks = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine()) - 1;
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            int[] next = {cur - rocks[cur], cur + rocks[cur]};
            for(int x : next) {
                if(x < 0 || x >= n || visit[x]) continue;
                q.add(x);
                visit[x] = true;
            }
        }
        System.out.println(cnt);
    }
}
