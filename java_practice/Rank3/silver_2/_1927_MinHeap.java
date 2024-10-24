package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927_MinHeap {
    public static void main(String[ ] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0) {
                if(q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(q.remove()).append("\n");
                }
            } else {
                q.add(cmd);
            }
        }

        System.out.println(sb);
    }
}
