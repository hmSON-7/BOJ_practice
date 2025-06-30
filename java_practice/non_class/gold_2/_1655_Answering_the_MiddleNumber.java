package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
BOJ_1655: 가운데를 말해요
N: 주어지는 정수의 개수(1 <= N <= 100_000)
n개의 수가 하나씩 주어질 때마다, 지금까지 모인 수 중 중간값을 말해야 함. 단, 중간값이 2개라면 작은 수를 말한다.
각 턴마다 어떤 숫자를 말해야 하는지 순서대로 출력하라.

1. smaller, larger 두 개의 오름차순 우선순위 큐와 mid 변수를 통해 매 턴마다 중간값을 최신화한다.
2. 주어지는 첫번째 수를 mid 값으로 초기화한 상태로 시작한다.
3. 두번째 숫자부터 mid 값보다 작으면 smaller, 그렇지 않으면 larger 큐에 숫자를 삽입한다.
3-1. 이 과정에서 smaller 큐의 사이즈가 larger 큐의 사이즈보다 크면 mid 값을 larger 큐에 삽입하고 smaller.poll() 값을 mid 변수에 저장한다.
3-2. 반대로 smaller 큐의 사이즈가 larger 큐의 사이즈보다 2 이상 작으면 mid 값을 smaller 큐에 삽입하고 larger.poll() 값을 mid 변수에 저장한다.
4. 매 턴마다 최신화를 진행한 후 mid 값을 출력한다.
*/

public class _1655_Answering_the_MiddleNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int mid = -10001;
    static PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> larger = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() throws IOException {
        int x = Integer.parseInt(br.readLine());
        if(mid == -10001) {
            mid = x;
            sb.append(x).append("\n");
            return;
        }

        if(x < mid) {
            smaller.add(x);
            if(smaller.size() > larger.size()) {
                larger.add(mid);
                mid = smaller.poll();
            }
            sb.append(mid).append("\n");
        } else {
            larger.add(x);
            if(larger.size() > smaller.size()+1) {
                smaller.add(mid);
                mid = larger.poll();
            }
            sb.append(mid).append("\n");
        }
    }
}
