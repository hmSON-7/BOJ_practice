package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
3649: 로봇 프로젝트

구멍을 막을 두 레고 조각이 필요함. 구멍의 너비 : x 센티미터, 구멍에 넣을 두 조각의 길이의 합이 구멍의 너비와 정확히 일치해야 함.

입력 :
x (구멍의 너비, 1 <= x <= 20). 이를 나노미터로 환산하면 최소 10,000,000nm/ 최대 200,000,000nm
n (레고 조각 개수, 0<= n <= 1000000)
arr[n] = l (레고 조각의 길이, 단위: nm, 최대 10cm(100,000,000nm)

정답이 여러 개인 경우 |l1 - l2|가 가장 큰 경우를 출력한다.
따라서 레고 배열을 정렬하고 투 포인터를 이용해 선택된 두 레고의 길이 합이 x값과 동일하면 그 즉시 해당 케이스를 출력한다.
마지막까지 x값과 일치하는 경우가 없으면 불가능함을 출력한다.
*/

public class _3649_RobotProject {
    static final int CM_TO_NM = 10_000_000;
    static int hole, n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = br.readLine()) != null && !(str.isEmpty())) {
            hole = Integer.parseInt(str) * CM_TO_NM;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() {
        int left = 0, right = n-1;
        while(left < right) {
            int x1 = arr[left], x2 = arr[right];
            int sum = x1 + x2;
            if(sum == hole) {
                sb.append("yes ").append(x1).append(" ").append(x2).append("\n");
                return;
            }
            if(sum < hole) left++;
            else right--;
        }
        sb.append("danger").append("\n");
    }
}
