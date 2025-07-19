package Rank4.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class _13549_HideAndSeek_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int su = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];
        Arrays.fill(visit, 100001);
        visit[su] = 0;
        Deque<int[]> deq = new ArrayDeque<>();
        if(su != bro) deq.addLast(new int[]{su, 0});
        while(!deq.isEmpty()) {
            int[] cur = deq.pollFirst();
            int p = cur[0];
            int curTime = cur[1];
            if(p == bro) {
                visit[p] = curTime;
                break;
            }
            int[] next = new int[]{p*2, p+1, p-1};
            int flag = p > bro ? 2 : 0;
            for(int i=flag; i<3; i++) {
                if(next[i] < 0 || next[i] >= 100001 || curTime+1 > visit[next[i]]) continue;
                if(i==0) {
                    visit[next[i]] = curTime;
                    deq.addFirst(new int[]{next[i], curTime});
                } else {
                    visit[next[i]] = curTime+1;
                    deq.addLast(new int[]{next[i], curTime+1});
                }
            }
        }
        System.out.println(visit[bro]);
    }
}
