package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        int size=topping.length;
        HashSet<Integer> left=new HashSet<>(); // 왼쪽
        HashMap<Integer, Integer> right=new HashMap<>(); // 오른쪽

        left.add(topping[0]); // 첫번째 값 넣어주기
        for(int i=1; i<size;i++){ // right에 값 넣어주기 두번째부터
            // topping 값이 있으면 해당 value +1, 없으면 0에 +1
            right.put(topping[i],right.getOrDefault(topping[i],0)+1);
        }
        // 첫 번째 자리일 때 비교
        if(left.size()== right.size()) answer++;

        // 둘을 비교해주는데 한 칸씩 뒤로 갈 때 right에서 값 빼주기, 0일 때 주의
        for(int i=1; i<size; i++){
            left.add(topping[i]); // 현재 값 왼쪽에 넣어주기
            right.put(topping[i], right.get(topping[i])-1); // 현재값 오른쪽에서 빼주기
            if(right.get(topping[i])==0){ // 오른쪽에 value가 0이면 빼주기
                right.remove(topping[i]);
            }
            if(left.size()== right.size()) answer++; // 사이즈 같을 때 답 ++
        }
        return answer;
    }
}
