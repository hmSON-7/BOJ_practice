package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class _5052_PhoneList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeSet<String> set = new TreeSet<>();
            for(int i=0; i<n; i++) {
                set.add(br.readLine());
            }
            boolean flag = true;
            String prev = null;
            for(String str : set) {
                if(prev != null && str.startsWith(prev)) {
                    flag = false;
                    break;
                }
                prev = str;
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
