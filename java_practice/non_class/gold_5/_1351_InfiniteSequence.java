package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
BOJ_1351: 무한 수열
무한 수열 A는 다음과 같은 규칙을 가진다.
- A[0] = 1
- A[i] = A[i/P] + A[i/Q](i >= 1)
N, P, Q가 주어질 때, A[N]을 구하라.(0 <= N <= 10^12, 2 <= P, Q <= 10^9)

1. HashMap 구조를 만들고 A[0]과 A[1]을 HashMap에 저장
2. N에 대한 분할 정복을 이용해 DP 구현
2-1. 이미 HashMap에 해당 키에 대한 값이 존재하는 경우 즉시 그 value 값을 리턴
2-2. 그렇지 않은 경우 key / p 와 key / q 에 대한 재귀 이후 결과값을 합해서 HashMap에 (key, res1 + res2) 형태로 저장
3. 분할 정복 종료 후 최종 결과 반환
*/

public class _1351_InfiniteSequence {
    static long n;
    static int p, q;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        map.put(0L, 1L);
        map.put(1L, 2L);
        System.out.println(dnc(n));
    }

    private static long dnc(long x) {
        if(map.containsKey(x)) return map.get(x);
        long res1 = dnc(x / p);
        long res2 = dnc(x / q);
        map.put(x, res1 + res2);
        return res1 + res2;
    }
}
