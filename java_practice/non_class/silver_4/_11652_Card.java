package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/*
BOJ_11652: 카드
N: 숫자 카드 수(1 <= N <= 100_000)
num: 각 숫자 카드에 적힌 수(-2^62 <= num <= 2^62)
주어지는 숫자 중 최빈값을 구하라. 단, 최빈값이 여러 가지라면 가장 작은 값을 출력한다.

1. TreeMap<Integer, Integer> 사용(자체 정렬을 지원하기 때문)
2. 트리셋 순환하면서 value가 제일 높은 key를 저장
3. 현재 순회중인 value 값이 maxCnt보다 높은 경우에만 결과값 최신화(제일 작은 key 값을 출력하기 위함)
*/

public class _11652_Card {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TreeMap<Long, Integer> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            long x = Long.parseLong(br.readLine());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    private static void solve() {
        long ans = 0; int maxCnt = 0;
        for(long key : map.keySet()) {
            int cnt = map.get(key);
            if(cnt > maxCnt) {
                maxCnt = cnt;
                ans = key;
            }
        }
        System.out.println(ans);
    }
}
