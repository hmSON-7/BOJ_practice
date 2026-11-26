package gold_5;

import java.io.*;
import java.util.*;

public class Main_6198 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n];
        for(int i=0; i<n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        int top = 0;
        long cnt = 0;
        int[] stack = new int[n];
        for(int i=0; i<n; i++) {
            while(top > 0 && height[stack[top-1]] <= height[i]) {
                cnt += i - stack[top-1] -1;
                top--;
            }

            stack[top++] = i;
        }

        while(top > 0) {
            cnt += n - stack[top-1] - 1;
            top--;
        }

        System.out.println(cnt);
    }

}