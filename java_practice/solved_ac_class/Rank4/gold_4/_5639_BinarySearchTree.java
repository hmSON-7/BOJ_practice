package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5639_BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void preorder(int n) {
            if(n < this.data) {
                if(this.left == null) this.left = new Node(n);
                else this.left.preorder(n);
            } else {
                if(this.right == null) this.right = new Node(n);
                else this.right.preorder(n);
            }
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            String str = br.readLine();
            if(str == null || str.trim().isEmpty()) {
                break;
            }
            int n = Integer.parseInt(str);
            root.preorder(n);
        }
        postorder(root);
        System.out.println(sb);
    }

    static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.getData()).append("\n");
    }
}
