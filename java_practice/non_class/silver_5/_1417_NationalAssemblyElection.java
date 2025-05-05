package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1417_NationalAssemblyElection {
    static int n, vote;
    static PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) - 1;
        vote = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
    }

    private static int solve() {
        if(q.isEmpty()) return 0;
        int curr = vote;
        while(vote <= q.peek()) {
            q.add(q.poll() - 1);
            vote++;
        }
        return vote - curr;
    }
}
