package silver_3;

import java.io.*;
import java.util.*;

public class Main_1935 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();

        int[] val = new int[n];
        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        int top = 0;
        double[] stack = new double[line.length];
        for(char ch : line) {
            if(ch >= 'A' && ch <= 'Z') {
                stack[top++] = val[ch - 'A'];
            } else {
                double y = stack[--top];
                stack[top-1] = operate(stack[top-1], y, ch);
            }
        }

        System.out.printf("%.2f", stack[0]);
    }

    static double operate(double x, double y, char op) {
        switch(op) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/': return x / y;
            default: return 0;
        }
    }

}