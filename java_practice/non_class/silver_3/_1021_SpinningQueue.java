package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _1021_SpinningQueue {
    static int len, m, cnt = 0;
    static LinkedList<Integer> deq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        len = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        for(int i=1; i<=len; i++) {
            deq.addLast(i);
        }
        String[] line = br.readLine().trim().split(" ");
        for(int i=0; i<m; i++) {
            int x = Integer.parseInt(line[i]);
            int idx = deq.indexOf(x);
            if(idx > deq.size() / 2) shiftRight(x);
            else shiftLeft(x);
        }

        System.out.println(cnt);
    }

    static void shiftLeft(int findNum) {
        while(true) {
            int num = deq.removeFirst();
            if(num == findNum) return;
            deq.addLast(num);
            cnt++;
        }
    }

    static void shiftRight(int findNum) {
        while(true) {
            int num = deq.removeLast();
            deq.addFirst(num);
            cnt++;
            if(num == findNum) break;
        }
        deq.removeFirst();
    }
}
