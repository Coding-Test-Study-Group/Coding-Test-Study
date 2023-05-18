package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String numString[] =new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numString[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(numString,new Comparator<>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        answer=String.join(answer,numString);
        // 숫자가 다 0일 때
        if(numString[0].equals("0")){
            answer="0";
        }
        return answer;
    }
}
