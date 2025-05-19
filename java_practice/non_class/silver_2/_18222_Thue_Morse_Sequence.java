package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18222_Thue_Morse_Sequence {
    static long n, len = 1;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve(n-1, len));
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        while(len < n) len *= 2;
    }

    private static long solve(long find, long size) {
        if(find <= 1) return find;
        long mid = size / 2;
        if(find < mid) return solve(find, mid);
        else return solve(find - mid, mid) == 0 ? 1 : 0;
    }
}
