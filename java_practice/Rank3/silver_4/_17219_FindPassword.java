package silver_4;

import java.util.*;
import java.io.*;

public class _17219_FindPassword {
    public static void main(String[] args) throws IOException {
        // 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int search = Integer.parseInt(info[1]);

        Map<String, String> site = new HashMap<>();
        while(n-- > 0) {
            String[] memo = br.readLine().split(" ");
            site.put(memo[0], memo[1]);
        }

        while(search-- > 0) {
            String key = br.readLine();
            sb.append(site.get(key)).append("\n");
        }

        br.close();

        String res = sb.toString();
        System.out.println(res);
    }
}
