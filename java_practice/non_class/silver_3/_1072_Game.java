package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1072_Game {
    static int x, y, z;
    public static void main(String[] args) throws IOException {
        read();
        if(x == y || z == 99) System.out.println("-1");
        else {
            System.out.println(search(1, x));
        }
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (int)(((long)y * 100) / x);
    }

    private static int search(int start, int end) {
        if(start > end) return start;

        int mid = (start + end) / 2;
        int newRate = (int)(((long)(y+mid) * 100) / (x+mid));
        if(newRate > z) return search(start, mid-1);
        return search(mid+1, end);
    }
}
