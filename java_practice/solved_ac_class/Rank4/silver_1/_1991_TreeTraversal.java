package Rank4.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char c;
    Node left, right;

    public Node(char c) {
        this.c = c;
        this.left = null;
        this.right = null;
    }
}

public class _1991_TreeTraversal {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char curr = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(tree[curr - 'A'] == null) {
                tree[curr - 'A'] = new Node(curr);
            }
            if(left != '.') {
                if(tree[left - 'A'] == null) tree[left - 'A'] = new Node(left);
                tree[curr - 'A'].left = tree[left - 'A'];
            }
            if(right != '.') {
                if(tree[right - 'A'] == null) tree[right - 'A'] = new Node(right);
                tree[curr - 'A'].right = tree[right - 'A'];
            }
        }
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        System.out.println(sb);
    }

    public static void preorder(Node root) {
        if(root == null) return;
        sb.append(root.c);
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        sb.append(root.c);
        inorder(root.right);
    }
    public static void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        sb.append(root.c);
    }
}
