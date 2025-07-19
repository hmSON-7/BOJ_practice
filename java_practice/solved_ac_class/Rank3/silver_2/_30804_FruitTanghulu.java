package Rank3.silver_2;

import java.io.*;
import java.util.*;

public class _30804_FruitTanghulu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] tanghulu = new int[total];
        for(int i=0; i<total; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 1, cntFruit = 1, maxCnt = 1;
        Map<Integer, Integer> fruits = new HashMap<>();
        fruits.put(tanghulu[0], 1);
        while(right < total) {
            int fruit = tanghulu[right++];
            cntFruit++;

            if(fruits.containsKey(fruit)) {
                fruits.put(fruit, fruits.get(fruit) + 1);
                maxCnt = Math.max(maxCnt, cntFruit);
                continue;
            }

            if(fruits.size() < 2) {
                fruits.put(fruit, 1);
                maxCnt = Math.max(maxCnt, cntFruit);
                continue;
            }

            fruits.put(fruit, 1);
            while(fruits.size() > 2) {
                int leftFruit = tanghulu[left++];
                fruits.put(leftFruit, fruits.get(leftFruit) - 1);
                if(fruits.get(leftFruit) == 0) {
                    fruits.remove(leftFruit);
                }
                cntFruit--;
            }

            maxCnt = Math.max(maxCnt, cntFruit);
        }

        System.out.println(maxCnt);
    }
}
