package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ_23758: 중앙값 제거
N: 주어질 자연수의 개수(1 <= N <= 2 * 10^6, Ai: 각 자연수(1 <= Ai <= 10^9)
N개의 값 중 중앙값을 찾아 2로 나누며, 나머지는 버린다. 이 연산은 N개의 수 중 0이 등장할 때까지 반복한다.
총 몇 번의 연산을 수행하는지 구하라.

1. 주어진 숫자들을 배열로 저장한 뒤 정렬한다. 이후 중앙값의 인덱스를 구하고, 그 뒤의 숫자는 일절 취급하지 않는다.
2. 어차피 모든 숫자를 2로 나누다 보면 1로 떨어지게 되어있다. 그 이후에는 반드시 숫자 0이 등장한다.
2-1. 이 점을 이용하여 중앙 인덱스까지의 모든 숫자가 1이 되기까지 몇 번의 연산을 요구하는 지 카운트한다.
3. 카운트된 값에 1을 더하면 최종 결과이다.
*/

public class _23758_Remove_the_MedianValue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int len;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        int n = Integer.parseInt(br.readLine());
        len = (n+1)/2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        int cnt = 0;
        for(int i=0; i<len; i++) {
            int curr = arr[i];
            while(curr > 1) {
                curr /= 2;
                cnt++;
            }
        }
        System.out.println(cnt + 1);
    }
}
