package jiWoo;

import java.util.*;
public class 정렬된리스트병합 {
    public static void main(String[] args){
        int [][] input={{1,4,5},{1,3,4},{2,6}};
        System.out.println(solution(input));
    }
    public static ArrayList<Integer> solution(int[][] inputs){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<inputs.length;i++){ // 리스트에 2차원 배열 값 전부를 넣어준다.
            for(int j=0; j<inputs[i].length;j++){
                list.add(inputs[i][j]);
            }
        }
        Collections.sort(list); // 리스트 오름차순 정렬
        return list;
    }
}




