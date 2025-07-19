package Rank3.silver_1;

import java.io.*;

public class _6064_CainCalendar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] info = br.readLine().trim().split(" ");
            int M = Integer.parseInt(info[0]);
            int N = Integer.parseInt(info[1]);
            int m = Integer.parseInt(info[2]);
            int n = Integer.parseInt(info[3]);

            int gcd = gcd(M, N);
            int diff = n - m;
            if(diff % gcd != 0) {
                sb.append(-1).append("\n");
                continue;
            }

            int lcm = M * N / gcd;
            int x = 0;
            int ans = -1;
            while (x * M < lcm) {
                if ((x * M + m - n) % N == 0) {
                    ans = x * M + m;
                    break;
                }
                x++;
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush(); br.close(); bw.close();
    }

    static int gcd(int a, int b) {
        int temp;
        if(a < b) {
            temp = a; a = b; b = temp;
        }
        return b == 0 ? a : gcd(b, a % b);
    }
}