package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6236_MonthlyExpense {
    static int n, m, max, total = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(search(max, total));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i< n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            max = Math.max(max, x);
            total += x;
        }
    }

    private static int search(int start, int end) {
        if(start > end) return start;

        int mid = (start + end) / 2;
        int cnt = getCnt(mid);
        return cnt > m ? search(mid + 1, end) : search(start, mid - 1);
    }

    private static int getCnt(int unit) {
        int cnt = 1, curr = unit;
        for(int i=0; i<n; i++) {
            int today = arr[i];
            if(today > curr) {
                cnt++;
                curr = unit;
            }
            curr -= today;
        }
        return cnt;
    }
}
