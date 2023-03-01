package taejun.programmers;

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];
        ArrayList<Integer> glory = new ArrayList<>();

        for(int i=0; i<score.length; i++) {
            if(glory.size() < k) {
                glory.add(score[i]);
                Collections.sort(glory);
            }
            else {
                if(score[i] > glory.get(0)) {
                    glory.set(0, score[i]);
                    Collections.sort(glory);
                }
            }
            answer[i] = glory.get(0);
        }
        
        return answer;
    }
}