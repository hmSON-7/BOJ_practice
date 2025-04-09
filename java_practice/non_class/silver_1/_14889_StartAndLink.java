package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_StartAndLink {
    static int[][] arr;
    static int[] team1, team2;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        team1 = new int[n/2]; team2 = new int[n/2];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team1[0] = 0; visited[0] = true;
        bt(1, 1);
        System.out.println(min);
    }

    static void bt(int idx, int start) {
        if(idx == n/2) {
            int cnt = 0;
            for(int i=0; i<n; i++) {
                if(!visited[i]) team2[cnt++] = i;
            }
            addStatus();
            return;
        }
        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                team1[idx] = i;
                bt(idx+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void addStatus() {
        int sum1 = 0, sum2 = 0;
        for(int i=0; i<n/2 - 1; i++) {
            for(int j=i+1; j<n/2; j++) {
                sum1 += arr[team1[i]][team1[j]] + arr[team1[j]][team1[i]];
                sum2 += arr[team2[i]][team2[j]] + arr[team2[j]][team2[i]];
            }
        }
        min = Math.min(min, Math.abs(sum1 - sum2));
        if(min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
}
