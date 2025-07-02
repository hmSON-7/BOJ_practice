package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
BOJ_2910: 빈도 정렬
N: 숫자의 개수(1 <= N <= 1_000), C: 각 숫자의 최대값(1 <= C <= 1_000_000_000)
주어지는 수열을 다음 규칙에 따라 빈도 정렬한 뒤 출력한다.
- 수열 내에서 많이 등장하는 수부터 앞에 배치한다. 예: 2 1 2 1 2 -> 2 2 2 1 1
- 만약 빈도가 동일한 숫자가 여러 개인 경우 먼저 입력된 것부터 배치한다. 예: 1 3 3 2 4 1 -> 1이 먼저 입력되었으므로 1 1 3 3, 2가 먼저 배치되었으므로 2 4

1. LinkedHashMap<Integer, Integer> 구조를 이용해 입력 순서를 보장받으면서 빈도 카운트
2. Key set 전체를 리스트로 옮긴 뒤 value에 대한 내림차순으로 정렬
3. value 크기만큼 key 값 입력
*/

public class _2910_FrequencySort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, max;
    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    private static void solve() {
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));
        for(int key : list) {
            for(int i=0; i<map.get(key); i++) {
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb);
    }
}
