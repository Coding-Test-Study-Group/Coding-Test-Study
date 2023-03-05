package jiWoo;
import java.util.*;
public class 프로그래머스_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = false;
        Arrays.sort(phone_book); // 숫자 문자열을 정렬하면 사전순으로 정렬된다.
        for(int i=0; i<phone_book.length-1; i++){ // 그러므로 뒤 문자만 비교
            int len=phone_book[i].length();
            // 다음 전화번호가 현재 번호보다 길고 잘랐을 때 같으면 false
            if(phone_book[i+1].length()>=len && phone_book[i+1].substring(0,len).equals(phone_book[i])){
                return answer;
            }
        }
        answer=true;
        return answer;
    }
}
