package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819_MaximizingDifference {
    static int n, max;
    static int[] arr, newArr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        read();
        backTracking(0);
        System.out.println(max);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        newArr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void backTracking(int cnt) {
        if(cnt == n) {
            int sum = 0;
            for(int i=0; i<n-1; i++) {
                sum += Math.abs(newArr[i] - newArr[i+1]);
            }
            max = Math.max(max, sum);
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                newArr[cnt] = arr[i];
                backTracking(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
