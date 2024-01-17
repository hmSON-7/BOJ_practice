import java.io.*;
import java.util.*;

public class _1654LAN {
    public static long Search(long[] k, long x, int need) {
        long left = 0, right = x + 1;
        while(left < right) {
            long sum = 0; long mid = (left + right) / 2;
            for (long i : k) {
                long part = i / mid;
                sum += part;
            }

            if(sum >= need) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = br.readLine().trim().split(" ");
        int kNum = Integer.parseInt(lines[0]);
        int needNum = Integer.parseInt(lines[1]);

        long[] k = new long[kNum];
        for(int i=0; i<kNum; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(k);
        System.out.println(Search(k, k[kNum - 1], needNum));
    }
}