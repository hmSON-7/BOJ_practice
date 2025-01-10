package gold_5;

import java.io.*;
import java.util.Arrays;

public class _5430_ACLanguage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int cnt = 0;
            for(int i=0; i<cmd.length(); i++) {
                if(cmd.charAt(i) == 'D') cnt++;
            }
            if(cnt > n) {
                sb.append("error\n"); continue;
            }

            String sub = line.substring(1, line.length() - 1).trim();
            String[] arr = sub.isEmpty() ? new String[0] : sub.split(",");
            int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

            int left = 0, right = n-1;
            boolean reverse = false;
            for(int i=0; i<cmd.length(); i++) {
                char c = cmd.charAt(i);
                if(c == 'R') reverse = !reverse;
                else {
                    if(reverse) right--;
                    else left++;
                }
            }

            sb.append("[");
            if(reverse) {
                for(int i=right; i>=left; i--) {
                    sb.append(nums[i]);
                    if(i == left) break;
                    sb.append(",");
                }
            } else {
                for(int i=left; i<=right; i++) {
                    sb.append(nums[i]);
                    if(i == right) break;
                    sb.append(",");
                }
            } sb.append("]\n");
        }

        System.out.println(sb);
    }
}
