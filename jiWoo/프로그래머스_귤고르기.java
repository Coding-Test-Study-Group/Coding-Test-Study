package jiWoo;
import java.util.*;
public class 프로그래머스_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int size=tangerine.length;
        // hashMap에 tangerine의 종류와 개수 넣어줌!
        HashMap<Integer, Integer> map= new HashMap<Integer,Integer>();
        for(int t:tangerine){
            int now=Integer.valueOf(t);
            if(map.containsKey(now)){
                map.put(now,map.get(t)+1);
            }else{
                map.put(now,1);
            }
        }
        // HashMap value 값만 내림차순 정렬하기
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());
        while(k>0){
            k-=list.get(answer);
            answer++;
        }
        return answer;
    }
}
