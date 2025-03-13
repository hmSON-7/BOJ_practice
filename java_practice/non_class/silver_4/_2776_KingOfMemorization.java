package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2776_KingOfMemorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int x = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<x; i++) {
                int call = Integer.parseInt(st.nextToken());
                sb.append(set.contains(call) ? "1" : "0").append("\n");
            }
        }
        System.out.println(sb);
    }
}
