package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _5904_MooGame {
    static int n, idx = 0;
    static List<Long> len = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        read(); getIdx();
        System.out.println(search(idx, n-1));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static void getIdx() {
        len.add(3L);
        while(true) {
            idx++;
            long next = len.get(idx-1) * 2 + (3 + idx);
            len.add(next);
            if(next > n) return;
        }
    }

    private static char search(int x, long pos) {
        if(x == 0) return pos == 0 ? 'm' : 'o';
        long leftLen = len.get(x-1);
        long midLen = 3 + x;
        if(pos < leftLen) return search(x-1, pos);
        else if(pos < leftLen + midLen) return pos - leftLen == 0 ? 'm' : 'o';
        else return search(x-1, pos - leftLen - midLen);
    }
}
