package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13913_HideAndSeek_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int su = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];
        int[] prev = new int[100001];
        Arrays.fill(visit, 100001);
        Arrays.fill(prev, -1);
        visit[su] = 0;
        prev[su] = su;
        Queue<Integer> q = new LinkedList<>();
        q.add(su);
        while(!q.isEmpty()) {
            int curPoint = q.poll();
            if(curPoint == bro) {
                break;
            }
            int flag = curPoint > bro ? 2 : 0;
            int[] next = new int[]{curPoint*2, curPoint+1, curPoint-1};
            for(int i=flag; i<next.length; i++) {
                if(next[i] < 0 || next[i]>= 100001 || visit[next[i]] != 100001) continue;
                visit[next[i]] = visit[curPoint]+1;
                q.add(next[i]);
                prev[next[i]] = curPoint;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(visit[bro]).append("\n");
        int path = bro;
        Stack<Integer> s = new Stack<>();
        while(true) {
            s.push(path);
            if(path == su) break;
            path = prev[path];
        }
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
