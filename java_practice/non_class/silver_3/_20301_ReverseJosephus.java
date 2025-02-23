package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _20301_ReverseJosephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int clock = Integer.parseInt(st.nextToken());
        int reverseCnt = Integer.parseInt(st.nextToken());
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i=1; i<=total; i++) {
            deq.addLast(i);
        }
        int cnt = 0, killCount = 0;
        boolean reverseFlag = false;
        StringBuilder sb = new StringBuilder();
        while(deq.size() > 1) {
            int cur = reverseFlag ? deq.removeLast() : deq.removeFirst();
            cnt++;
            if(cnt == clock) {
                cnt = 0;
                killCount++;
                sb.append(cur).append("\n");
                if(killCount == reverseCnt) {
                    reverseFlag = !reverseFlag;
                    killCount = 0;
                }
                continue;
            }
            if(reverseFlag) deq.addFirst(cur);
            else deq.addLast(cur);
        }
        sb.append(deq.removeFirst());
        System.out.println(sb);
    }
}
