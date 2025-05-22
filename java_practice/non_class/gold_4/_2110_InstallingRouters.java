package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110_InstallingRouters {
    static int n, router;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        router = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        int max = arr[n-1] - arr[0];
        int min = max;
        for(int i=0; i<n-1; i++) {
            int diff = arr[i+1] - arr[i];
            min = Math.min(min, diff);
        }
        System.out.println(search(min, max));
    }

    private static int search(int min, int max) {
        if(min > max) return max;

        int mid = (max + min) / 2;
        int routerCnt = 1, preRouter = arr[0];
        for(int i=1; i<n; i++) {
            int next = arr[i];
            if(next - preRouter < mid) continue;
            preRouter = next;
            routerCnt++;
            if(routerCnt >= router) break;
        }
        if(routerCnt < router) return search(min, mid - 1);
        else return search(mid+1, max);
    }
}
