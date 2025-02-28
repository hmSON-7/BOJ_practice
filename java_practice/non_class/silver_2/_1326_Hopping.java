package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1326_Hopping {
    public static int[] direction = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1, end = Integer.parseInt(st.nextToken()) - 1;
        if(start == end) {
            System.out.println(0);
            return;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curPnt = cur[0];
            int curCnt = cur[1];
            for(int d : direction) {
                int next = curPnt;
                while(true) {
                    next += d * arr[curPnt];
                    if(next == end) {
                        System.out.println(curCnt + 1);
                        return;
                    }
                    if(next < 0 || next >= n) break;
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(new int[]{next, curCnt+1});
                }
            }
        }
        System.out.println(-1);
    }
}
