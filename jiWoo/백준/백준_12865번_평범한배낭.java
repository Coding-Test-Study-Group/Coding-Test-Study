package jiWoo.백준;

import java.util.*;
public class 백준_12865번_평범한배낭 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); // 물품의 수
        int K=sc.nextInt();  // 버틸 수 있는 무게
        int [][] D=new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            int W=sc.nextInt();
            int V=sc.nextInt();

            for(int j=1; j<=K;j++){
                if(j<W){  // 가능한 값보다 현재 무게가 더 무거우면
                    D[i][j]=D[i-1][j]; // 현재 물품이 포함되기 전
                }else{ // j 이상이면
                    // 현재 물건이 들어가기 전과 현재 물건을 뺀 값(최대)에 현재 물건의 가치를 더한 값 중 최대
                    D[i][j]=Math.max(D[i-1][j], D[i-1][j-W]+V);
                }
            }
        }

        System.out.println(D[N][K]);
    }
}
