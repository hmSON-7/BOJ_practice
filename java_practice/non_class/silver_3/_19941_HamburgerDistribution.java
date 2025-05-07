package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19941_HamburgerDistribution {
    static int n, dist;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dist = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
    }

    private static int solve() {
        int cnt = 0;
        for(int i=1; i<n; i++) {
            char c = arr[i];
            for(int j = Math.max(i-dist, 0); j<i; j++) {
                if(arr[j] != 'X' && c != arr[j]) {
                    arr[i] = 'X'; arr[j] = 'X';
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
