package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4256_Tree {
    static int t, n;
    static int[] preorder, inorder;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            read();
            postOrder(0, 0, n-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        preorder = new int[n];
        inorder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void postOrder(int rootIdx, int start, int end) {
        if(start > end) return;

        int root = preorder[rootIdx];
        if(start == end) {
            sb.append(root).append(" ");
            return;
        }

        for(int i=start; i<=end; i++) {
            if(root == inorder[i]) {
                postOrder(rootIdx+1, start, i-1);
                postOrder(rootIdx+(i-start+1), i+1, end);
                sb.append(root).append(" ");
                return;
            }
        }
    }
}
