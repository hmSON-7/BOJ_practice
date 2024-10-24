package silver_1;

import java.io.*;

public class _1074Z {
    static int findTarget(int n, int x1, int y1, int x2, int y2, int x, int y, int cnt) {
        if(n == 1) return cnt;

        int res;
        int midX = (x1 + x2 + 1) / 2; int midY = (y1 + y2 + 1) / 2;
        int len = n/2;
        if(x < midX && y < midY) { // 0
            res = findTarget(len, x1, y1, midX-1, midY-1, x, y, cnt);

        } else if(x >= midX && y < midY) { // 1
            cnt += (int)Math.pow(len, 2);
            res = findTarget(len, midX, y1, x2, midY-1, x, y, cnt);

        } else if(x < midX) { // 2
            cnt += 2 * (int)Math.pow(len, 2);
            res = findTarget(len, x1, midY, midX-1, y2, x, y, cnt);

        } else {
            cnt += 3 * (int)Math.pow(len, 2); // 3
            res = findTarget(len, midX, midY, x2, y2, x, y, cnt);
        }

        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        int n = Integer.parseInt(info[0]);
        n = (int)Math.pow(2, n);
        int y = Integer.parseInt(info[1]);
        int x = Integer.parseInt(info[2]);
        int cnt = 0;

        cnt = findTarget(n, 0, 0, n-1, n-1, x, y, cnt);
        System.out.println(cnt);
    }
}