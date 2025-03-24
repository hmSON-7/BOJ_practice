package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9934_CompleteBinaryTree {
    static int level, total, cnt = 0;
    static int[] tree, nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        level = Integer.parseInt(br.readLine());
        total = (int)Math.pow(2, level) - 1;
        nums = new int[total];
        tree = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        inorder(0);
        StringBuilder sb = new StringBuilder();
        sb.append(tree[0]).append("\n");
        for(int i=1; i<level; i++) {
            int start = (int)Math.pow(2, i) - 1;
            int end = (int)Math.pow(2, i+1) - 1;
            for(int j=start; j<end; j++) {
                sb.append(tree[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void inorder(int curr) {
        if(curr >= total) return;
        inorder(2*curr+1);
        tree[curr] = nums[cnt++];
        inorder(2*curr+2);
    }
}
