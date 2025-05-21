package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2161_Card1 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        read(); solve();
        System.out.println(sb);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        int idx = 0;
        while(true) {
            sb.append(list.remove(idx)).append(" ");
            if(list.isEmpty()) break;
            idx = (idx+1)%list.size();
        }
    }
}
