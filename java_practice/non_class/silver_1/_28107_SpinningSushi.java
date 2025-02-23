package silver_1;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Sushi {
    int customerId;
    int kind;

    public Sushi(int customerId, int kind) {
        this.customerId = customerId;
        this.kind = kind;
    }
}

public class _28107_SpinningSushi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int wait = Integer.parseInt(st.nextToken());
        int sushi = Integer.parseInt(st.nextToken());
        int[] eaten = new int[wait];
        PriorityQueue<Sushi> q = new PriorityQueue<>((a, b) -> a.kind != b.kind ?
                a.kind - b.kind : a.customerId - b.customerId);
        PriorityQueue<Integer> spinning = new PriorityQueue<>();
        for(int i=0; i<wait; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while(n-->0) {
                q.add(new Sushi(i, Integer.parseInt(st.nextToken())));
            }
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            spinning.add(Integer.parseInt(st.nextToken()));
        }
        while(!spinning.isEmpty()) {
            int next = spinning.poll();
            while(!q.isEmpty() && q.peek().kind < next) q.poll();
            if(!q.isEmpty() && q.peek().kind == next) {
                Sushi s = q.poll();
                eaten[s.customerId]++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<wait; i++) {
            bw.write(eaten[i] + " ");
        }
        bw.flush();
    }
}
