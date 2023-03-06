package jiWoo;
import java.util.*;
public class 강사님_그룹애너그램 {
    public static void main(String[] args){
        String [] inputs= {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution(inputs);
    }

    public static void solution(String[] input){
        int len=input.length;
        String[] temp=new String[len]; // 각 문자열을 정렬해서 받아줄 배열
        for(int i=0; i<len; i++){
            char[] arr=input[i].toCharArray(); // 해당 문자열을 정렬하기 위해서 char 배열로 받아준다.
            Arrays.sort(arr); // 정렬
            temp[i]=new String(arr); // input에 들어있는 String들이 각각 정렬된 상태로 String 배열에 들어간다.
        }
        // hash를 사용해서 각자 정렬된 값들에 input 값을 넣어준다.
        HashMap<String, ArrayList<String>> map=new HashMap<>();

        for(int i=0; i<len; i++){
           if(map.containsKey(temp[i])){ // 해당값이 있으면 그 value 리스트에 add
               map.get(temp[i]).add(input[i]);
               map.put(temp[i], map.get(temp[i]));
           }else{ // 없으면 새로운 리스트에 넣는다.
               ArrayList<String> li=new ArrayList<>();
               li.add(input[i]);
               map.put(temp[i],li);
           }
        }
        ArrayList<ArrayList<String>> list=new ArrayList(map.values()); // value들을 리스트로 변환
        System.out.println(list);
    }

}
