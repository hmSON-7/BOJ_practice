package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
M: 사대의 수, N: 동물의 수, Range: 사대의 거리
각 사대의 x좌표가 주어진다.
각 동물의 좌표 또한 (x, y)의 형태로 주어진다.
잡을 수 있는 동물의 수를 출력하자. 답은 반드시 음수가 아닌 정수이다.

각 사대의 위치를 등록하고 각 동물의 위치와 정중앙 사대의 위치를 통해 실제 거리를 구한다.
최대 사거리인 Range보다 작거나 같다면 즉시 이분 탐색을 종료하고 카운트.
최대 사거리인 Range보다 길다면 현 사대의 x좌표를 이용해 새 탐색범위를 지정한다.
즉, 각 동물마다 이분 탐색을 돌려야 함.
*/

public class _8983_Hunter {
    static int m, n, range;
    static int[] launch;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        launch = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            launch[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(launch);
    }

    private static void solve() throws IOException {
        int cnt = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(search(x, y)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean search(int x, int y) {
        int left = 0, right = m-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int curr = launch[mid] - x;
            if(Math.abs(curr) + y <= range) return true;
            if(curr < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
