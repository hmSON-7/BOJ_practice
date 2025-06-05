package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1477: 휴게소 세우기

현재 고속도로에 N개의 휴게소가 있고, 각 휴게소의 거리는 고속도로의 시작점으로부터 얼만큼 떨어져 있는지 정수값으로 주어짐.
이 상황에서 M개의 휴게소를 추가 건설하여 휴게소가 없는 구간의 길이 최대값을 최소화하려 함.
이미 휴게소가 있는 곳과 고속도로 끝에는 휴게소를 설치할 수 없음.

N: 현재 휴게소 수(0~50), M: 추가하려는 휴게소 수(1~100), L: 고속도로의 총 길이(100~1000, N+M<L)
arr[i] = 각 휴게소와 시작점 간의 거리(N이 0이면 해당 값은 입력으로 주어지지 않음)(1~(l-1))

1. 각 휴게소의 시작점 기준 거리가 아닌, 각 지점별 거리를 등록(시작점 - 첫 휴게소, 마지막 휴게소 - 도착점 간 거리도 포함한다.)
2. 1번 과정에서 최대 거리를 따로 max 변수에 저장해뒀다가 이분 탐색의 초기 end 값으로 사용
3. 이분 탐색 과정에서의 mid 변수는 각 거리의 시작점부터 새 휴게소까지의 거리임.
3-1. 즉, 각 거리에 mid 간격으로 최대 몇 개의 휴게소를 설치할 수 있는지 본다
3-1-1. 각 구간별 거리를 mid 값으로 나눈 몫을 추가하되, 완전히 나누어떨어지면 1개 감소시킨다.
3-1-2. 이는 중복된 위치에 휴게소를 설치할 수 없다는 규칙을 준수하기 위함이다.(예: 구간 거리가 210인데, 70마다 새 휴게소를 설치할 경우)
3-2. m 값보다 더 많이 설치되면 start 값을 mid+1 로 올리고, m 값보다 적거나 동일하게 설치되면 end 값을 mid-1 로 내리면서 범위를 확정할 것
4. start 값이 end 값보다 커졌을 때, 적절히 설치된 경우에도 end 값을 내렸으므로 start 값을 최종 반환

#1. 기존에 휴게소가 없는 경우(N == 0)도 존재하므로 0인 경우 추가 입력 시도를 금할 것
#2. 어떤 수를 써도 구간별 거리 최대값을 줄일 수 없는 경우도 있음(arr = {3, 6}, M = 1, L = 9인 경우 휴게소를 어디에 설치해도 max = 3이 유지됨)
        #3. 따라서 이분 탐색 전 최대 거리 구간은 초기 max 값으로 설정, 이분 탐색의 초기 end 값도 max 값부터 시작해야 함.
*/

public class _1477_EstablishingRestArea {
    static int n, m, len;
    static int[] arr, highway;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        if(n != 0) {
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
        }
    }

    private static void solve() {
        int max = 0, prev = 0;
        highway = new int[n+1];
        for(int i=0; i<n; i++) {
            int curr = arr[i];
            int dist = curr - prev;
            highway[i] = dist;
            if(dist > max) max = dist;
            prev = curr;
        }
        highway[n] = len - prev;
        if (highway[n] > max) max = highway[n];

        int start = 1, end = max, ans = max;
        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for(int d : highway) {
                int pt = (d / mid) + (d%mid == 0 ? -1 : 0);
                cnt += pt;
                if(cnt > m) break;
            }
            if(cnt > m) start = mid + 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
