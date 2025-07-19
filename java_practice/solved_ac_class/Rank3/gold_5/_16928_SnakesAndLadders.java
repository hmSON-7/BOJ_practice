package Rank3.gold_5;

import java.io.*;
import java.util.*;

public class _16928_SnakesAndLadders {
    static int[] board = new int[101];
    static int[] visit = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i<board.length; i++) {
            board[i] = i;
            visit[i] = -1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for(int i=0; i<l+s; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            board[before] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        int res = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curNum = cur[0], curTime = cur[1] + 1;
            boolean maxFlag = true;
            for(int i=6; i>=1; i--) {
                int next = curNum + i;
                if(next >= 100) {
                    res = curTime;
                    break;
                }
                if(visit[board[next]] > -1 || (board[next] == next && !maxFlag)) continue;
                if(board[next] == next) maxFlag = false;
                q.add(new int[]{board[next], curTime});
                visit[board[next]] = curTime;
            }
            if(res > 0) break;
        }

        System.out.println(res);
    }
}
