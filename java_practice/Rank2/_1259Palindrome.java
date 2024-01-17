import java.util.*;

public class _1259Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.next();
            if(str.equals("0")) break;

            int left = 0, right = str.length()-1;
            boolean flag = true;
            while(left <= right) {
                if(Objects.equals(str.charAt(left), str.charAt(right))) {
                    left++; right--;
                } else {
                    flag = false; break;
                }
            }

            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
