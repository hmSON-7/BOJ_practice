package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ_2792: 보석 상자
N: 아이들의 수(1 <= N <= 10^9), M: 보석 색상 종류(1 <= M <= 300_000, M <= N)
모든 보석을 학생들에게 나누어줄 것이며, 보석을 받지 못하는 경우도 존재한다
각 학생은 항상 같은 색상의 보석만 가져간다
질투심 수치 : 가장 많은 보석을 가져간 학생의 보석 개수
학생의 수, 보석의 종류, 각 색깔을 가진 보석의 수가 주어질 때, 질투심 수치를 최소화하라

1. 각 색깔을 가진 보석의 개수 중 최대값을 max 값으로 등록
2. 질투심 수치, 즉 한 학생이 가질 수 있는 보석의 최대 개수를 이분 탐색으로 찾는다. left = 1, right = max
3. 각 보석의 개수를 mid 값으로 나눠 질투심 수치를 유지하면서 총 몇명의 학생에게 나눠줄 수 있는지 카운트
3-1. 카운트가 학생의 수보다 많다면 모든 보석을 나눠줄 수 없음(left = mid + 1)
3-2. 카운트가 학생의 수보다 적거나 같다면 모든 보석을 나눠줄 수 있음(ans 등록, right = mid - 1)
4. 이분 탐색 종료 후의 ans 값이 질투심 수치의 최소값이다.
*/

public class _2792_JewelryBox {
    static int n, m, max = 0;
    static int[] jewels;
    public static void main(String[] args) throws Exception {
        read(); solve();
    }

    private static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        jewels = new int[m];
        for(int i=0; i<m; i++) {
            int x = Integer.parseInt(br.readLine());
            jewels[i] = x;
            if(x > max) max = x;
        }
    }

    private static void solve() {
        int left = 1, right = max, ans = 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i=0; i<m; i++) {
                int x = jewels[i];
                cnt += x / mid;
                if(x % mid != 0) cnt++;
            }
            if(cnt > n) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
