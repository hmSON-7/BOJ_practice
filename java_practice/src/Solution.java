import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, maxH;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            init();
            sb.append("#").append(i).append(" ");
            solve();
        }
        System.out.println(sb);
    }

    public static void init() throws Exception {
        maxH = 0;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if(x > maxH) maxH = x;
        }
    }

    public static void solve() {
        int cnt1 = 0, cnt2 = 0, dayCnt = 0;

        // 1. 최대 길이가 되기까지 남은 길이 수를 3으로 나누고, 경과일수만큼 일수 카운트 추가
        for(int i=0; i<n; i++) {
            int remain = maxH - arr[i];
            int req = remain % 3;
            dayCnt += remain / 3 * 2;
            if(req == 1) cnt1++;
            else if(req == 2) cnt2++;
        }
        // 2. 남은 길이 2는 1 두 번으로 쪼갤 수 있음
        while(cnt2 > cnt1 + 1) {
            cnt2--; cnt1 += 2;
        }
        // 3. 남은 길이가 1, 2인 나무가 남아있다면 그만큼 쌍을 만들어서 성장. 쌍 하나당 2일 경과
        int pairCnt = Math.min(cnt1, cnt2);
        cnt1 -= pairCnt; cnt2 -= pairCnt;
        dayCnt += pairCnt * 2;
        // 4. 이 과정을 거치고도 남은 나무는 휴일을 거쳐서라도 성장시켜야 함.
        if(cnt1 > 0) dayCnt += (cnt1 * 2) - 1;
        if(cnt2 > 0) dayCnt += cnt2 * 2;

        sb.append(dayCnt).append("\n");
    }

    /*
    20 6 (12 + 12

    20
    1 3 6 5 5 1 5 4 3 5 4 2 4 6 5 5 4 5 5 3

    1 : 3
    2 : 0
    */

}