package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
#19637: IF문 좀 대신 써줘

각 칭호와 기준 전투력 상한값이 주어진다(총 n개, 1 <= n <= 10^5). 이후 캐릭터 k개의 전투력이 주어진다(1 <= k <= 10^5).
각 칭호의 순서는 전투력 상한값의 비내림차순이며, 상한값이 동일한 경우 먼저 입력된 칭호만 출력한다.
각 캐릭터의 전투력에 맞는 칭호를 부여하라.

1. 먼저 문자열 배열에 각 칭호를, 정수 배열에 각 상한값을 입력된 순서대로 추가한다.
2. 이분 탐색은 칭호의 개수를 기준으로 0~n-1 안에서 돌린다.
2-1. 캐릭터 전투력이 상한값을 초과하면 해당 칭호는 필요 없으므로 left = mid + 1
2-2. 캐릭터 전투력이 상한값을 초과하지 못하면 해당 칭호를 받을 가능성이 있으므로 right = mid - 1
2-3. left 인덱스에 해당하는 칭호를 부여한다.
*/

public class _19637_PleaseWrite_IfSentence_forMe {
    static int n, k;
    static String[] titles;
    static int[] limits, player;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        titles = new String[n];
        limits = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            limits[i] = Integer.parseInt(st.nextToken());
        }
        player = new int[k];
        for(int i=0; i<k; i++) {
            player[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for(int cp : player) {
            int idx = search(cp);
            sb.append(titles[idx]).append("\n");
        }
        System.out.println(sb);
    }

    private static int search(int cp) {
        int left = 0, right = n - 1, ans = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(cp > limits[mid]) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
}
