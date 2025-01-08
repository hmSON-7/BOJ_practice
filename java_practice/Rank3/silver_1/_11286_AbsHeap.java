package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _11286_AbsHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) ->
                Math.abs(a) != Math.abs(b) ? Integer.compare(Math.abs(a), Math.abs(b)) : Integer.compare(a, b));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0) {
                if(q.isEmpty()) sb.append(0);
                else sb.append(q.poll());
                sb.append("\n");
            } else {
                q.add(cmd);
            }
        }

        System.out.println(sb);
    }
}
