import java.util.*;

public class _1676FactorialCnt0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt2 = 0, cnt5 = 0;
        for(int i=1; i<=n; i++) {
            int num = i;
            while(num%2 == 0) {
                num /= 2;
                cnt2++;
            }

            while(num%5 == 0) {
                num /= 5;
                cnt5++;
            }
        }

        System.out.println(Math.min(cnt2, cnt5));
    }
}