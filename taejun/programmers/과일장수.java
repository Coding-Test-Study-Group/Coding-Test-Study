package taejun.programmers;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int bucketLength = score.length / m;
        int[] buckets = new int[bucketLength];
        int idx = 0;
        for(int i=score.length-1; i>=m-1; i-=m) {
            int min = 0;
            for(int j=i; j>i-m; j--) {
                min = Math.min(10, score[j]);
            }
            buckets[idx] = min * m;
            idx++;
        }
        for(int bucket  : buckets) answer += bucket;
        System.out.println(answer);
        return answer;
    }
}