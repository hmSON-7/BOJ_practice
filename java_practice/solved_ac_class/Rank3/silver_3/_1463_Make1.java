package Rank3.silver_3;

import java.io.*;

public class _1463_Make1 {
    static Integer[] memo;

    static int recursion(int n) {
        if(memo[n] == null) {
            if(n%6 == 0) {
                memo[n] = Math.min(recursion(n-1), Math.min(recursion(n/3), recursion(n/2))) + 1;
            } else if(n%3 == 0) {
                memo[n] = Math.min(recursion(n/3), recursion(n-1)) + 1;
            } else if(n%2 == 0) {
                memo[n] = Math.min(recursion(n/2), recursion(n-1)) + 1;
            } else {
                memo[n] = recursion(n-1) + 1;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        memo = new Integer[n+1];
        memo[0] = memo[1] = 0;

        bw.write(Integer.toString(recursion(n)));

        bw.flush();
        br.close();
        bw.close();
    }
}
