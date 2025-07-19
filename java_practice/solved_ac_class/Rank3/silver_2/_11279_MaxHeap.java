package Rank3.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _11279_MaxHeap {
    static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0) {
                int removed = q.isEmpty() ? 0 : q.remove();
                sb.append(removed).append("\n");
            } else {
                q.add(cmd);
            }
        }

        System.out.println(sb);
    }
}
