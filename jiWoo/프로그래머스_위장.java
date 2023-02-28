package jiWoo;
import java.util.*;
public class 프로그래머스_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        int len=clothes.length;
        HashMap<String, Integer> map= new HashMap<String, Integer>();
        for(int i=0; i<len; i++){ // 해당 옷 종류의 개수 구해주기(0개 포함해서)
            String kind=clothes[i][1]; // 옷 종류
            if(map.containsKey(kind)){
                map.put(kind,map.get(kind)+1);
            }else{
                map.put(kind,2); // 0개도 넣어주기
            }
        }
        // 리스트에 종류에 따른 개수를 넣어주고 그 값을 다 곱한다.
        List<Integer> list=new ArrayList<>(map.values());
        for(int n:list){
            answer*=n;
        }
        return answer-1; // 하나를 빼주는 건 다 0개일 때
    }
}
