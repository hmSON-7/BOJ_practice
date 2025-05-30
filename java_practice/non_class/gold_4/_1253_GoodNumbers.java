package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1253_GoodNumbers {
    static int n;
    static int[] keys;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        keys = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int key = Integer.parseInt(st.nextToken());
            keys[i] = key;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        Arrays.sort(keys);
    }

    private static void solve() {
        int cnt = 0, prev = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int x = keys[i];
            if(x == prev) continue;
            if(checkGoodNumber(i, x)) cnt += map.get(x);
            prev = x;
        }
        System.out.println(cnt);
    }

    private static boolean checkGoodNumber(int idx, int currNum) {
        int left = 0, right = n - 1;
        while(left < right) {
            if(left == idx) {
                left++; continue;
            } if(right == idx) {
                right--; continue;
            }
            int sum = keys[left] + keys[right];
            if(sum == currNum) return true;
            if(sum > currNum) right--;
            else left++;
        }
        return false;
    }
}
