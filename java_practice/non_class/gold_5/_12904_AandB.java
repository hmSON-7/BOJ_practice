package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12904_AandB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        StringBuilder sb = new StringBuilder(br.readLine());
        while(sb.length() > start.length()) {
            char deleted = sb.charAt(sb.length()-1);
            sb.delete(sb.length()-1, sb.length());
            if(deleted == 'B') {
                sb.reverse();
            }
        }
        System.out.println(sb.toString().compareTo(start) == 0 ? 1 : 0);
    }
}
