package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15903_CardCombinationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        long n1, n2, sum, total = 0;
        for(int i=0; i<t; i++) {
            n1 = pq.poll(); n2 = pq.poll();
            sum = n1 + n2;
            while(!pq.isEmpty() && pq.peek() >= sum && i < t-1) {
                sum *= 2; i++;
            }
            pq.add(sum); pq.add(sum);
        }
        while(!pq.isEmpty()) {
            total += pq.poll();
        }
        System.out.println(total);
    }
}
