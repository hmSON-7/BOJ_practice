package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17298_NextGreaterElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] stack = new int[n];
        int sp = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            while (sp > 0 && stack[sp - 1] <= cur) {
                sp--;
            }
            res[i] = (sp == 0) ? -1 : stack[sp - 1];
            stack[sp++] = cur;
        }
        StringBuilder sb = new StringBuilder();
        for(int r : res) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}
