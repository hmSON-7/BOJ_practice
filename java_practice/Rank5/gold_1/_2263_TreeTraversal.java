package gold_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2263_TreeTraversal {
    static int[] inorder, postorder;
    static HashMap<Integer, Integer> inMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inMap.put(inorder[i], i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        preorder(0, n-1, 0, n-1);
        System.out.println(sb);
    }

    static void preorder(int startI, int endI, int startP, int endP) {
        if(startI > endI) return;

        int rootNum = postorder[endP];
        sb.append(rootNum).append(" ");
        if(startI == endI) return;

        int idx = inMap.get(rootNum);
        int leftSize = idx - startI, rightSize = endI - idx;
        preorder(startI, idx - 1, startP, startP + leftSize - 1);
        preorder(idx + 1, endI, startP + leftSize, endP - 1);
    }
}
