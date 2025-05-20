package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1802_Origami {
    static int n;
    static char[][] papers;
    public static void main(String[] args) throws IOException {
        read();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            boolean res = solve(0, papers[i].length-1, i);
            sb.append(res ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        papers = new char[n][];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            papers[i] = input.toCharArray();
        }
    }

    private static boolean solve(int start, int end, int idx) {
        if(start == end) return true;
        int mid = (start + end)/2;
        int left = mid-1, right = mid+1;
        while(left >= start && right <= end) {
            if(papers[idx][left] == papers[idx][right]) return false;
            left--; right++;
        }
        return solve(start, mid - 1, idx) && solve(mid + 1, end, idx);
    }
}
