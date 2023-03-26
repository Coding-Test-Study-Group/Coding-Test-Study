package jiWoo;
import java.util.*;
public class 프로그래머스_뉴스클러스터링
{
    static HashSet<String> set=new HashSet<>();
    public int solution(String str1, String str2) {
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();
        int answer = 0;
        if(str1.length()==0 && str2.length()==0) return 1;
        HashMap<String, Integer> s1=new HashMap<>();
        HashMap<String, Integer> s2=new HashMap<>();

        putInHash(str1, s1);
        putInHash(str2, s2);

        int min=0;
        int max=0;
        for(String key: set){
            // 교집합, 합집합 구하기
            if(s1.containsKey(key) && s2.containsKey(key)){
                min+=Math.min(s1.get(key),s2.get(key));
                max+=Math.max(s1.get(key),s2.get(key));
            }else{
                if(s1.containsKey(key)) max+=s1.get(key);
                else max+=s2.get(key);
            }
        }
        double result=(double)min/max;
        if(min==0 && max==0) result=1; // 교집합과 합집합 모두 0일 때
        result*=65536;
        answer=(int)result;
        return answer;
    }

    // str 두 글자씩 끊어서 hashMap에 넣기
    public static void putInHash(String str, HashMap<String, Integer> map){
        int len=str.length();
        loop: for(int i=0; i<len-1; i++){
            String putStr=str.substring(i,i+2).trim(); //   i번째부터 2글자 추출, 공백제거
            // 공백이나 숫자, 특수문자 버리기
            if(putStr.length()!=2) continue;
            for(char c: putStr.toCharArray()){
                if(!Character.isLetter(c)) continue loop;
            }
            set.add(putStr); // 합집합과 교집합 찾아줄 때 사용
            if(map.containsKey(putStr)){
                map.put(putStr,map.get(putStr)+1); // 해당 2글자 포함 개수 +1
            }else map.put(putStr,1); // 넣어주기
        }
    }
}
