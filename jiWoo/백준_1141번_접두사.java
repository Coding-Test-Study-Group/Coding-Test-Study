package jiWoo;

import java.util.*;

public class 백준_1141번_접두사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 단어의 길이를 오름차순으로 정렬
        PriorityQueue<word> words = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String now = sc.next();
            words.add(new word(now.length(), now));
        }
        int result=0;

        for (int i = 0; i < N; i++) {
            String now = words.poll().word;
            boolean check = false;
            for (word w : words) {
                if (w.word.indexOf(now)==0) {
                    check = true;
                }
            }
            if(!check) result++;
        
        }

        System.out.println(result);

    }
}

class word implements Comparable<word> {
    int length;
    String word;

    word(int length, String word) {
        this.length = length;
        this.word = word;
    }

    @Override
    public int compareTo(word target) { // 단어 길이 오름차순
        return this.length >= target.length ? 1 : -1;
    }
}
