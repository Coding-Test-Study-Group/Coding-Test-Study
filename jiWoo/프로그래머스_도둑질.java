package jiWoo;
import java.util.*;
public class 프로그래머스_도둑질 {
    public int solution(int[] money) {
        int answer = 0;
        // money 배열의 크기
        int len=money.length;
        // 첫 번째와 두 번째집을 구별하기 위해서
        int first[] =new int[len];
        int second[]= new int[len];

        // 배열 초깃값
        for(int i=0; i<len; i++){
            first[i]=money[i];
            second[i]=money[i];
        }
        // 서로 값 -1로 구별
        first[1]=-1;
        second[0]=-1;
        if(len>3){ // 집이 3개만 있으면 첫번째와 세번째는 인접해있으므로
            first[2]+=first[0];
        }
        // 점화식
        // 마지막은 첫번째집과 인접해있으므로 마지막 집 전까지
        for(int i=3; i<len; i++){
            // 첫번째 두번째만 비교하면서 2,3 떨어져있는 집 중 최대값 넣어줌
            // 둘도 인접해서 더 큰 값을 넣어주기 위해 둘 비교
            first[i]+=Math.max(first[i-2],first[i-3]);
            second[i]+=Math.max(second[i-2],second[i-3]);
        }

        // 답은 뒤에 두 집 비교
        // first는 마지막 집과 인접해있으므로 뒤에서 두번쨰 세번째 비교
        // second는 마지막 집과 두번째 비교
        int firstMax=Math.max(first[len-2],first[len-3]);
        int secondMax=Math.max(second[len-1],second[len-2]);

        answer=Math.max(firstMax,secondMax);
        return answer;
    }
}
