package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541_LostParentheses {
    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split("");
        int sum = 0; boolean flag = false;

        StringBuilder sb = new StringBuilder();
        for(String s : str) {
            try {
                sb.append(Integer.parseInt(s));
            } catch(NumberFormatException e) {
                if(flag) {
                    sum -= Integer.parseInt(sb.toString());
                } else {
                    sum += Integer.parseInt(sb.toString());
                }

                sb.setLength(0);
            }

            if(s.equals("-")) flag = true;
        }

        if(flag) {
            sum -= Integer.parseInt(sb.toString());
        } else {
            sum += Integer.parseInt(sb.toString());
        }

        System.out.println(sum);
    }
}
