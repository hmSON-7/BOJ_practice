import java.util.*;

public class _1920SearchNum {
    public static int binarySearch(Set<Integer> set, int key) {
        if (set.contains(key)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> nums = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        int m = sc.nextInt();
        int[] res = new int[m];
        int key;
        for (int i = 0; i < m; i++) {
            key = sc.nextInt();
            res[i] = binarySearch(nums, key);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }
    }
}