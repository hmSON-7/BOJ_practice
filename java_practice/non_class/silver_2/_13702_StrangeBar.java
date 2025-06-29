package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ_13702: 이상한 술집
주전자의 용량은 항상 동일하나 주전자 안 막걸리의 용량은 랜덤
N: 주문한 주전자 개수(1 <= N <= 10_000), K: 자신을 포함한 친구 수(1 <= N <= K <= 1_000_000)
분배 후 주전자에 막걸리가 남아있다면 그냥 버린다. 분배 후 모든 친구가 가진 막걸리의 양은 동일해야 한다.
친구 K명에게 최대한 많은 양의 막걸리를 분배할 수 있는 용량은 몇 ml인지 출력하라.

1. 주어지는 막걸리 용량 중 최대값을 max 값으로 등록
2. 각 인원이 받는 막걸리의 양을 이분 탐색으로 찾는다(left = 1, right = max)
3. 각 주전자에 든 막걸리의 양을 mid값으로 나눠 카운트에 추가
3-1. 카운트가 인원수 K보다 작다면 해당 용량으로 분배 불가. right = mid - 1
3-2. 카운트가 인원수 K보다 많거나 같다면 해당 용량으로 분배 가능. left = mid + 1
*/

public class _13702_StrangeBar {
    static int n, k, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            if(x > max) max = x;
        }
    }

    private static void solve() {
        if(n == 1) {
            System.out.println(max / k);
            System.exit(0);
        }
        int left = 1, right = max, ans = 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i=0; i<n; i++) {
                int x = arr[i];
                cnt += x / mid;
            }
            if(cnt < k) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
