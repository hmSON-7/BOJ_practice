package gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17140 {
    static int maxR, maxC, r, c, goal;
    static int[] lenArr = new int[100];
    static int[][] arr = new int[100][100];
    static HashMap<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<Integer> q = new PriorityQueue<>((a, b) ->
            !Objects.equals(map.get(a), map.get(b)) ? map.get(a) - map.get(b) : a - b);

    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 목표 지점 및 목표값 입력
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        goal = Integer.parseInt(st.nextToken());
        // 배열 기본 정보 입력
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxR = 3; maxC = 3;
    }

    public static void solve() {
        int t = 0;
        // 100
        while(t < 100) {
            int target = arr[r][c];
            if(target == goal) break;

            if(maxR >= maxC) operateR();
            else operateC();
            t++;
        }

        if(t < 100) System.out.println(t);
        else System.out.println(arr[r][c] == goal ? t : -1);
    }

    public static void operateR() {
        int maxLenC = 0;
        for(int i=0; i<maxR; i++) {
            for(int j=0; j<maxC; j++) {
                int curr = arr[i][j];
                if(curr == 0) continue;
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
            q.addAll(map.keySet());
            int idxCnt = 0;
            while(!q.isEmpty() && idxCnt < 100) {
                int num = q.poll();
                arr[i][idxCnt++] = num;
                arr[i][idxCnt++] = map.get(num);
            }
            lenArr[i] = idxCnt;
            if(idxCnt > maxLenC) maxLenC = idxCnt;
            map.clear();
            if(!q.isEmpty()) q.clear();
        }
        maxC = maxLenC;
        for(int i=0; i<maxR; i++) {
            for(int j=lenArr[i]; j<maxC; j++) arr[i][j] = 0;
        }
    }

    public static void operateC() {
        int maxLenR = 0;
        for(int i=0; i<maxC; i++) {
            for(int j=0; j<maxR; j++) {
                int curr = arr[j][i];
                if(curr == 0) continue;
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
            q.addAll(map.keySet());
            int idxCnt = 0;
            while(!q.isEmpty() && idxCnt < 100) {
                int num = q.poll();
                arr[idxCnt++][i] = num;
                arr[idxCnt++][i] = map.get(num);
            }
            lenArr[i] = idxCnt;
            if(idxCnt > maxLenR) maxLenR = idxCnt;
            map.clear();
            if(!q.isEmpty()) q.clear();
        }
        maxR = maxLenR;
        for(int i=0; i<maxC; i++) {
            for(int j=lenArr[i]; j<maxR; j++) arr[j][i] = 0;
        }
    }
}
