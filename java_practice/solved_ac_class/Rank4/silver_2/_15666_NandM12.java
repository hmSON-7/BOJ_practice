package Rank4.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _15666_NandM12 {
    static int n, m;
    static int[] arr, nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        String[] line = br.readLine().trim().split(" ");
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(Integer.parseInt(line[i]));
        }
        nums = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(nums);
        arr = new int[m];

        bt(0, 0);
        System.out.println(sb);
    }

    static void bt(int idx, int x) {
        if(idx == m) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=x; i<nums.length; i++) {
            arr[idx] = nums[i];
            bt(idx+1, i);
        }
    }
}
