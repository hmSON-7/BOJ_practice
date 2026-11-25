package silver_4;

import java.io.*;
import java.util.*;

public class Main_3986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] stack = new char[100_000];
        int top, cnt = 0;

        for(int i=0; i<n; i++) {
            top = 0;
            char[] line = br.readLine().toCharArray();
            for(char ch : line) {
                if(top != 0 && ch == stack[top-1]) {
                    top--;
                    continue;
                }

                stack[top++] = ch;
            }

            if(top == 0) cnt++;
        }

        System.out.println(cnt);
    }

}