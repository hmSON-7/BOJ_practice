package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16926_SpinningArray_1 {
    static int y, x, round; // 세로, 가로, 회전 횟수
    static int[][] arr; // 돌릴 배열
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열 크기 및 회전 횟수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        round = Integer.parseInt(st.nextToken());

        // 배열 값 입력
        arr = new int[y][x];
        for(int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        // 배열 회전 메소드
        rotateArr();

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotateArr() {
        /*
         * 큐를 이용해 한 줄을 round값만큼 한꺼번에 이동시키고자 함
         * 바깥줄부터 시작해 모든 값을 큐에 넣고, round만큼 poll과 add를 반복
         * 이후 큐 순서대로 배열에 값 재배치
         */

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<Math.min(y,  x) / 2; i++) {
            // 한 라인의 모든 값을 큐에 입력
            for(int j=i+1; j<x-i; j++) q.add(arr[i][j]);
            for(int j=i+1; j<y-i; j++) q.add(arr[j][x-i-1]);
            for(int j=x-i-2; j>=i; j--) q.add(arr[y-i-1][j]);
            for(int j=y-i-2; j>=i; j--) q.add(arr[j][i]);

            // round 수만큼 큐에서 데이터 제거 및 재입력 반복
            for(int j=0; j<round; j++) q.add(q.poll());

            // 다시 순서대로 모든 값을 재배치
            for(int j=i+1; j<x-i; j++) arr[i][j] = q.poll();
            for(int j=i+1; j<y-i; j++) arr[j][x-i-1] = q.poll();
            for(int j=x-i-2; j>=i; j--) arr[y-i-1][j] = q.poll();
            for(int j=y-i-2; j>=i; j--) arr[j][i] = q.poll();
            q.clear();
        }
    }
}
