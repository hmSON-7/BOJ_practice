package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int right = str1.length(), left = 0, min = str2.length();
        while(right <= str2.length()) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(str2, 0, left).append(str1).append(str2, right, str2.length());
            String newStr = sb.toString();
            for(int i=0; i<newStr.length(); i++) {
                if(newStr.charAt(i) != str2.charAt(i)) cnt++;
            }
            min = Math.min(min, cnt);
            left++; right++;
        }
        System.out.println(min);
    }
}
