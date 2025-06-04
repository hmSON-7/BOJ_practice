package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/*
2295_세 수의 합

n : 숫자의 개수(5 <= n <= 1_000). 이 중 3개의 숫자를 골라야 함.
세 수의 합 d가 집합 U 안에 포함되어있는 경우가 반드시 존재한다. 이 조건에 부합하는 d 중 최대값을 찾아야 함.
집합 U : n개의 숫자 포함. 숫자 중복 없고 각 원소는 200_000_000 이하인 자연수임.
단, d를 만드는 데 필요한 x, y, z 세 개의 수는 중복을 허용함.

        1. 더해야 할 숫자의 개수는 3개로 고정됨. 따라서 Set 자료구조를 만들어 2개의 숫자만 합한 값의 목록을 세트에 저장
2. 이후 제일 큰 값부터 역순으로 순환하며 target = arr[i] - arr[j](i > j)이 세트 내에 존재하는 지 확인
3. 존재하면 그 때의 arr[i]가 최대값이므로 그 즉시 arr[i]를 출력하고 실행 종료.
*/

public class _2295_Sum_of_ThreeNumbers {
    static int n;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        read(); solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }

    private static void solve() {
        for(int i=0; i<n-1; i++) {
            for(int j=i; j<n-1; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                int targetNum = arr[i] - arr[j];
                if(set.contains(targetNum)) {
                    System.out.println(arr[i]);
                    System.exit(0);
                }
            }
        }
    }
}
