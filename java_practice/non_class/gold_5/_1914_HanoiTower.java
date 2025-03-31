package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1914_HanoiTower {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger res = BigInteger.valueOf(2).pow(n).subtract(BigInteger.valueOf(1));
        sb.append(res).append("\n");
        if(n <= 20) buildTower(n, 1, 2, 3);
        System.out.println(sb);
    }

    static void buildTower(int n, int src, int mid, int dest) {
        if(n == 1) {
            sb.append(src).append(" ").append(dest).append("\n");
            return;
        }
        buildTower(n-1, src, dest, mid);
        sb.append(src).append(" ").append(dest).append("\n");
        buildTower(n-1, mid, src, dest);
    }
}
