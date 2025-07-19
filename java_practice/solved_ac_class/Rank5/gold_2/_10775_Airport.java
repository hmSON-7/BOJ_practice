package Rank5.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10775_Airport {
    static int g, p;
    static int[] arr, gates;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        arr = new int[p];
        for(int i=0; i<p; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static int solve() {
        gates = new int[g+1];
        int cnt = 0;
        for(int i=1; i<=g; i++) gates[i] = i;
        for(int x : arr) {
            int emp = find(x);
            if(emp == 0) break;
            cnt++;
            union(emp, emp - 1);
        }
        return cnt;
    }

    private static void union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if(p1 != p2) gates[p1] = p2;
    }

    private static int find(int x) {
        if(gates[x] == x) return x;
        return gates[x] = find(gates[x]);
    }
}
