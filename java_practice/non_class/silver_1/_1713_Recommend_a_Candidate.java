package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _1713_Recommend_a_Candidate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeMap<Integer, Picture> map = new TreeMap<>();
    static int limit, n;
    public static void main(String[] args) throws Exception {
        limit = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(map.containsKey(next)) {
                Picture p = map.get(next);
                p.recommendedCnt++;
                map.put(next, p);
                continue;
            }
            if(map.size() < limit) {
                map.put(next, new Picture(i, 1));
                continue;
            }

            int target = -1, minCnt = Integer.MAX_VALUE, oldest = i;
            for(int key : map.keySet()) {
                Picture p = map.get(key);
                if(p.recommendedCnt > minCnt) continue;
                if(p.recommendedCnt < minCnt) {
                    minCnt = p.recommendedCnt;
                    target = key;
                    oldest = p.postedTime;
                    continue;
                }
                if(p.postedTime < oldest) {
                    target = key;
                    oldest = p.postedTime;
                }
            }
            map.remove(target);
            map.put(next, new Picture(i, 1));
        }

        StringBuilder sb = new StringBuilder();
        for(int key : map.keySet()) {
            sb.append(key).append(" ");
        }
        System.out.println(sb);
    }

    static class Picture {
        int postedTime, recommendedCnt;

        public Picture(int postedTime, int recommendedCnt) {
            this.postedTime = postedTime;
            this.recommendedCnt = recommendedCnt;
        }
    }
}
