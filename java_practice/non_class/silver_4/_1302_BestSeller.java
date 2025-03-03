package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _1302_BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        String best = null;
        int maxCnt = 0;
        for(String s : map.keySet()) {
            if(best == null || map.get(s) > maxCnt) {
                best = s;
                maxCnt = map.get(s);
            }
        }
        System.out.println(best);
    }
}
