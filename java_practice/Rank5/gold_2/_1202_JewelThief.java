package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _1202_JewelThief {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bags = Integer.parseInt(st.nextToken());
        int[][] gems = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(gems, (a, b) -> b[1] - a[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<bags; i++) {
            int w = Integer.parseInt(br.readLine());
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        long sum = 0;
        for(int[] gem : gems) {
            Integer cap = map.ceilingKey(gem[0]);
            if(cap != null) {
                sum += gem[1];
                int cnt = map.get(cap);
                if(cnt == 1) map.remove(cap);
                else map.put(cap, cnt - 1);
            }
        }
        System.out.println(sum);
    }
}
