package jiWoo.백준;
import java.util.*;
public class 백준_2579번_계단오르기{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] score=new int[n+1];
        score[0]=0; // 시작
        for(int i=1; i<=n; i++){ // 점수 넣기
            score[i]=sc.nextInt();
        }
        int D[]=new int[n+1]; // i 계단 까지 점수의 최대값
        int D1[]= new int[n+1]; // i계단에서 한 칸인 값
        int D2[]= new int[n+2]; // i계단에서 두 칸째일 때

        D[0]=score[0]; // 시작점
        D[1]= score[1]; D1[1]=score[1];// 첫번째
        for(int i=2; i<=n;i++){
            D1[i]=D[i-2]+score[i]; // 2칸 전 최대값에 현재 점수값 더하기, 무조건 두칸 전에서 와서 연속된 거 생각안해줘도 ㄱㅊ
            D2[i]=D1[i-1]+score[i]; // 한 칸 온 거에서 현재 값 더하기
            D[i]=Math.max(D1[i],D2[i]);
        }
        System.out.println(D[n]);
    }
}
