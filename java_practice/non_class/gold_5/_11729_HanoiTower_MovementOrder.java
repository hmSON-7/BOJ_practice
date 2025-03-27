package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11729_HanoiTower_MovementOrder {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append((1 << n) - 1).append("\n");
        buildTower(n, 1, 2, 3);
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
