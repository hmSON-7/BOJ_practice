package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14622_PrimeNumberGame {
    static boolean[] primes, used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Player[] players = new Player[2];
        for(int i=0; i<2; i++) {
            players[i] = new Player();
        }
        primes = checkPrime(5000000);
        used = new boolean[primes.length];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                int x = Integer.parseInt(st.nextToken());
                isPrime(players[j], x, players[(j+1)%2]);
            }
        }
        if(players[0].cnt > players[1].cnt) System.out.println("소수의 신 갓대웅");
        else if(players[0].cnt < players[1].cnt) System.out.println("소수 마스터 갓규성");
        else System.out.println("우열을 가릴 수 없음");
    }

    static void isPrime(Player p, int x, Player op) {
        if(primes[x]) {
            if(used[x]) p.cnt -= 1000;
            else {
                used[x] = true;
                p.updateMax(x);
            }
            return;
        }
        if(op.max3 == -1) op.cnt += 1000;
        else {
            op.cnt += op.max3;
        }
    }

    public static boolean[] checkPrime(int max) {
        boolean[] isPrime = new boolean[max+1];
        for(int i=2; i<=max; i++) isPrime[i] = true;
        for(int i=2; i*i<=max; i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<max; j+=i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}

class Player {
    long cnt;
    int max1, max2, max3;

    public Player() {
        cnt = 0;
        max1 = -1; max2 = -1; max3 = -1;
    }

    public void updateMax(int x) {
        if(x > max1) {
            max3 = max2; max2 = max1; max1 = x;
        } else if(x > max2) {
            max3 = max2; max2 = x;
        } else if(x > max3) {
            max3 = x;
        }
    }
}