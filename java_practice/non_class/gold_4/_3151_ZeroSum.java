package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3151: 합이 0

학생의 수 N(1 <= N <= 10_000)과 각 학생의 코딩 실력이 정수 arr[i](-10_000 <= arr[i] <= 10_000)로 주어짐
이 중 3명을 한 팀으로 구성하여 코딩 실력의 합계를 0으로 만들어 출전시키는 경우의 수를 구해야 함
반드시 3명을 구성해야 하며, 여러 학생이 동일한 코딩 실력을 가지고 있을 수 있음

1. 가장 직관적인 방법은 3명으로 고정되는 점을 이용하여 한 명을 고정한 상태에서 나머지 2명을 투 포인터로 탐색하는 방법임.
2. 합이 0이 되는 3인 조합을 발견할 경우 각 능력치에 해당하는 사람의 수를 전부 곱한 것이 해당 케이스의 경우의 수임.
        2-1. 조건에 부합하는 두 수가 다른 값인 경우 각 숫자를 곱한 결과를 카운트
2-2. 조건에 부합하는 두 수가 동일한 값인 경우, 2개 이상이라면 조합 공식을 이용해 경우의 수 계산
*/

public class _3151_ZeroSum {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        long totalCnt = 0;
        for(int i=0; i<n; i++) {
            int fix = arr[i];
            if(fix > 0) break;

            int left = i+1, right = n-1;
            while(left < right) {
                int x1 = arr[left], x2 = arr[right];
                int sum = x1 + x2 + fix;
                if(sum == 0) {
                    if(x1 == x2) {
                        totalCnt += combination(right - left + 1);
                        break;
                    }
                    int cnt1 = 0, cnt2 = 0;
                    while(arr[left] == x1) {
                        left++; cnt1++;
                    }
                    while(arr[right] == x2) {
                        right--; cnt2++;
                    }
                    totalCnt += (long)cnt1 * cnt2;
                    continue;
                }
                if(sum > 0) right--;
                else left++;
            }
        }
        System.out.println(totalCnt);
    }

    private static long combination(int num) {
        return (long)num * (num - 1) / 2;
    }
}
