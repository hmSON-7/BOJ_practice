package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _15654_NandM5 {
    static int n, m;
    static int[] arr, nums;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        String[] line = br.readLine().trim().split(" ");
        nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(nums);
        arr = new int[m];
        visit = new boolean[n];

        bt(0);
        System.out.println(sb);
    }

    static void bt(int idx) {
        if(idx == m) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[idx] = nums[i];
            bt(idx+1);
            visit[i] = false;
        }
    }
}
