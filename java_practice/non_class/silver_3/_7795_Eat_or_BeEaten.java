package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7795_Eat_or_BeEaten {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cntA, cntB;
    static int[] arrA, arrB;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            read();
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        cntA = Integer.parseInt(st.nextToken());
        cntB = Integer.parseInt(st.nextToken());
        arrA = new int[cntA];
        arrB = new int[cntB];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cntA; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cntB; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
    }

    private static int solve() {
        int idxA = 0, cnt = 0;
        for(int i=0; i<cntB; i++) {
            int x = arrB[i];
            while(idxA < cntA && arrA[idxA] <= x) idxA++;
            if(idxA == cntA) break;
            cnt += cntA - idxA;
        }
        return cnt;
    }
}
