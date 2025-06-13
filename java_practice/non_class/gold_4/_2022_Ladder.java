package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
사다리 x, y의 길이와 교차점 c의 높이가 주어진다.
(0 < x, y, c <= 3_000_000_000인 양의 실수)
두 빌딩 사이의 넓이를 출력한다. 절대/상대 오차는 10^-3까지 허용한다.

1. 두 빌딩 사이 넓이는 최저 0, 최고 min(x, y)이다. 빌딩 사이의 넓이에 대한 이분 탐색을 시도한다.
2. 두 사다리의 길이(빗변)와 밑변의 길이가 주어지므로 각 직각삼각형의 sin(x)를 구할 수 있다.
2-1. 이 문제를 해결하기 위해서는 cos(x)를 알아야 하는데, (sin(x))^2 + (cos(x))^2 == 1임을 알면 cos(x)를 구할 수 있다.
2-2. 두 사다리의 교차점이 어디인지보다는 높이가 c일 때 빗변이 어디고, 밑변의 길이가 어느 정도인지를 생각한다.
2-3. 두 작은 삼각형의 밑변의 길이 합계가 빌딩 사이의 넓이와 동일하면 정확한 넓이를 찾아낸 것이다.
*/


public class _2022_Ladder {
    static double x, y, crossed;
    public static void main(String[] args) throws IOException {
        read(); solve(Math.min(x, y));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        crossed = Double.parseDouble(st.nextToken());
    }

    private static void solve(double end) {
        double left = 0, right = end, ans = 0;
        final double EPS = 1e-4;
        while(right - left > EPS) {
            double mid = (left + right) / 2;
            double sin1 = mid/x, sin2 = mid/y;
            double cos1 = Math.sqrt(1 - (sin1*sin1));
            double cos2 = Math.sqrt(1 - (sin2*sin2));
            double line1 = crossed / cos1, line2 = crossed / cos2;
            double res = (line1 * sin1) + (line2 * sin2);
            if(res > mid) right = mid;
            else {
                ans = mid;
                left = mid;
            }
        }
        System.out.printf("%.3f\n", ans);
    }
}
