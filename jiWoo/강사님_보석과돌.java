package jiWoo;
import java.util.*;
public class 강사님_보석과돌 {
        public static void main(String[] args){
            System.out.println(solution("aA","aAAbbbb"));
            System.out.println(solution("z","ZZ"));
        }
        public static int solution(String jewels, String stones){
            int result=0;
            // jewels를 String-> char[] 배열로 변환하고 리스트에 넣기
            char [] jew=jewels.toCharArray();
            ArrayList<Character> li=new ArrayList<>();
            for(char c: jew){
                li.add(c);
            }

            for(int i=0; i<stones.length(); i++){ // stone에 문자가 jewels 리스트 에 포함하면 result ++;
                if(li.contains(stones.charAt(i))){
                    result++;
                }
            }
            return result;
        }

}
