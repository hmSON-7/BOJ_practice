import java.util.*;
import java.io.*;

public class _18110SolvedAC {
    public static void main(String[] args) throws IOException{
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] ranks = new int[t];
        for(int i=0; i<t; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ranks);

        // 절사평균 구하기
        int d = (int) Math.round(t * 0.15);
        int sum = 0;
        for(int i=d; i<t-d; i++) {
            sum += ranks[i];
        }
        int avgRounded = (int) Math.round((double) sum / (t - 2*d));

        System.out.println(avgRounded);
    }
}