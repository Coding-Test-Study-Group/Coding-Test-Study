package jiWoo;
import java.util.*;
public class 프로그래머스_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int size=numbers.length;
        int[] answer = new int[size];
        Stack<Integer> sk= new Stack<>(); // 인덱스 저장하기
        for(int i=0; i<size; i++){ // 현재값이 전 값보다 작다면 스택에 넣기
            if(sk.isEmpty() || numbers[i]<numbers[i-1]){
                sk.add(i);
            }else{
                while(!sk.isEmpty() && numbers[sk.peek()]<numbers[i]){
                    // 현재값이 전 값보다 크다면 스택에서 작은 값들 pop해서 answer=현재값 넣어주기
                    answer[sk.pop()]=numbers[i];
                }
                sk.add(i);
            }
        }
        // 나머지는 큰 값이 없는 것이므로
        while(!sk.isEmpty()){
            answer[sk.pop()]=-1;
        }
        return answer;
    }
}
