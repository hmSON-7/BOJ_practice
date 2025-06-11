package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
n: 배열 크기, m: 구간 수
arr[n] 배열을 m개 이하의 구간으로 나누어 구간 점수 중 최대값을 최소로 하려고 함
각 구간은 최소 1개의 숫자가 반드시 존재해야 함
구간 점수 : 각 구간에 속한 수의 최대값과 최소값의 차
구간 점수의 최대값 중 최소값을 구하여라.

1. 먼저 가장 작은 숫자와 가장 큰 숫자의 차이를 비교한다. 즉, m이 1일 때의 구간 점수이다.
1-1. 만약 m이 1로 입력된다면 추가적으로 알고리즘을 진행하지 않고 현재의 구간 점수를 출력한 뒤 종료한다.
2. 이분 탐색의 범위는 0~diff 로 진행한다.(diff 변수는 구간 점수이다.)
3. mid 값이 허용 가능한 최대 구간 점수라고 전제하고, 배열을 순회하면서 최대 구간 점수를 벗어나면 구간을 분리하는 카운트를 추가한다.
3-1. 만약 구간 분리 카운트가 m을 초과한다면 더 탐색할 필요는 없으니 left = mid + 1
3-2. 구간이 m개 이하라면 현재의 최대 구간 점수를 갱신하고 right = mid - 1
4. 이분 탐색이 완전히 종료된 뒤 기록 되어있는 diff 값이 결과이다.
*/

public class _13397_Segmentation_2 {
    static int n, m, min = 10001, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if(x < min) min = x;
            if(x > max) max = x;
        }
    }

    private static void solve() {
        int diff = max - min;
        if(m == 1 || diff == 0) {
            System.out.println(diff);
            return;
        }
        int left = 0, right = diff;
        while(left <= right) {
            int mid = (left + right) / 2;
            int currMin = 10001, currMax = 0, cnt = 1;
            for(int i=0; i<n; i++) {
                int x = arr[i];
                if(x < currMin) currMin = x;
                if(x > currMax) currMax = x;
                if(currMax - currMin > mid) {
                    cnt++;
                    currMin = currMax = x;
                    if(cnt > m) break;
                }
            }
            if(cnt > m) left = mid + 1;
            else {
                right = mid - 1;
                diff = mid;
            }
        }
        System.out.println(diff);
    }
}
