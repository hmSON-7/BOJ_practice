package Rank2;

import java.util.*;

public class _1874StackSequence {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nums = new int[t];
        for(int i=0; i<t; i++) {
            nums[i] = sc.nextInt();
        }

        int pushNum = 1, seq = 0;
        Stack<Integer> s = new Stack<>();
        while(pushNum <= t) {
            s.push(pushNum++);
            sb.append("+").append("\n");

            while(!s.isEmpty() && s.peek() == nums[seq]) {
                s.pop(); seq++;
                sb.append("-").append("\n");
            }
        }

        while(!s.isEmpty()) {
            if(s.peek() == nums[seq]) {
                s.pop();
                seq++;
                sb.append("-").append("\n");
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}