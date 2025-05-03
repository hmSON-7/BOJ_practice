package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _2812_MakingBiggest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] str = br.readLine().toCharArray();
        Deque<Character> deq = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            char next = str[i];
            while(!deq.isEmpty() && deq.peekLast() < next && k > 0) {
                deq.removeLast();
                k--;
            }
            deq.addLast(next);
        }
        StringBuilder sb = new StringBuilder();
        while(deq.size() > k) {
            sb.append(deq.removeFirst());
        }
        System.out.println(sb);
    }
}
