package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2473_ThreeSolutions {
    static int n;
    static long minDiff = Long.MAX_VALUE;
    static int[] arr, sols;
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sols = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        for(int i=0; i<n; i++) {
            int sol1 = arr[i];
            boolean getZero = search(sol1, i);
            if(getZero) break;
        }
        Arrays.sort(sols);
        System.out.println(sols[0] + " " + sols[1] + " " + sols[2]);
    }

    private static boolean search(int currValue, int idx) {
        int left = 0, right = n-1;
        while(left < right) {
            if(left == idx) {
                left++; continue;
            } if(right == idx) {
                right--; continue;
            }
            int n1 = arr[left], n2 = arr[right];
            long diff = Math.abs((long)n2 + n1 + currValue);
            if(diff < minDiff) {
                minDiff = diff;
                sols[0] = currValue; sols[1] = n1; sols[2] = n2;
            }

            if(diff == 0L) return true;
            if(n2 + n1 < -1 * (currValue)) left++;
            else right--;
        }
        return false;
    }
}
