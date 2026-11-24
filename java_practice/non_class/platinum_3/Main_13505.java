package platinum_3;

import java.io.*;
import java.util.*;

public class Main_13505 {

    static final int MAX_BITS = 30, MASK = (1 << MAX_BITS) - 1;
    static int[][] trie;
    static int triePointer = 0, max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        trie = new int[n *  MAX_BITS + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(st.nextToken());
            int flipped = val ^ MASK;

            updateMaxXOR(flipped);
            setTrie(val);
        }

        System.out.println(max);
    }

    static void updateMaxXOR(int flipped) {
        if(triePointer == 0) return;

        int sum = 0, cur = 0;
        for(int i=MAX_BITS-1; i>=0; i--) {
            int bit = (flipped >> i) & 1;
            if(trie[cur][bit] != 0) {
                sum += 1 << i;
                cur = trie[cur][bit];
            } else {
                cur = trie[cur][bit ^ 1];
            }
        }

        if(sum > max) max = sum;
    }

    static void setTrie(int val) {
        int cur = 0;

        for(int i=MAX_BITS-1; i>=0; i--) {
            int bit = (val >> i) & 1;
            if(trie[cur][bit] == 0) {
                trie[cur][bit] = ++triePointer;
            }

            cur = trie[cur][bit];
        }
    }

}