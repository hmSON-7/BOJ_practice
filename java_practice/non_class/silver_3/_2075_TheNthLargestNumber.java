package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2075_TheNthLargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, Integer.parseInt(st.nextToken()));
        }
        q.add(max);
        for(int i=2; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                int peek = q.peek();
                if(x > peek) q.add(x);
            }
            while(q.size() > i) q.poll();
        }
        System.out.println(q.poll());
    }
}
