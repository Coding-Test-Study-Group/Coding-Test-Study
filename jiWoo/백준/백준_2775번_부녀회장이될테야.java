package jiWoo.백준;

import java.util.*;
public class 백준_2775번_부녀회장이될테야 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(); // T: 테스트케이스의 수
        
        for(int i=0;i<T;i++){
            int k=sc.nextInt(); // k층
            int n=sc.nextInt(); // n호
            int D[][]=new int[k+1][n+1];
            for(int j=1;j<=n;j++) D[0][j]=j; // 0층에는 j호에 j만큼 산다
            for(int j=1; j<=k;j++){
                for(int c=1;c<=n;c++){
                    D[j][c]=D[j-1][c]+D[j][c-1];  // D[j-1][c] 내 위층에 사는 사람 수 + D[j][c-1] 내 위층 사는 사람 빼고 누적 수
                }
            }
            System.out.println(D[k][n]);
        }
    }
}
