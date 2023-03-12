package jiWoo;
import java.util.*;
public class 프로그래머스_연속부분수열의합의개수 {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set=new HashSet<>();
        int len= elements.length;
        for(int i=1 ;i<=len; i++){
            for(int j=0; j<len; j++){
                int sum=0;
                for(int k=0; k<i; k++){
                    if(j+k>=len){
                        sum+=elements[j+k-len];
                    }else sum+=elements[j+k];
                }
                set.add(sum);
            }
        }
        answer=set.size();
        return answer;
    }
}
