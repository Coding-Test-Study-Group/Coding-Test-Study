package jiWoo;
import java.util.*;
public class 백준_11053번_가장긴증가하는부분수열 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int A[]=new int[N]; // 수열 A
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int D[]=new int[N];
        int max=1;
        for(int i=0;i<N;i++) D[i]=1; // 모든 칸은 자기 자신을 읽어준다고 생각하고 1로 초기화

        for(int i=0;i<N-1;i++){ // i+1번째부터 A[i]보다 큰 값들에 D[i]+1과 D[j]값 중 큰 값 넣어주기
            for(int j=i+1;j<N;j++){
                if(A[j]>A[i]){
                    D[j]=Math.max(D[j],D[i]+1);
                    max=Math.max(D[j],max); // max 찾아주기
                }
            }
        }
        System.out.println(max);
    }
}
