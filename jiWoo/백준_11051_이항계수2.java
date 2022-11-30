package jiWoo;
import java.util.*;
public class 백준_11051_이항계수2 {

    static int mod=10007;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        long [][] D=new long[N+1][N+1];
        for(int i=1;i<=N;i++){
            D[i][0]=1;
            D[i][i]=1;
            D[i][1]=i;
        }

        for(int i=2;i<=N;i++){
            for(int j=2;j<N;j++){
                D[i][j]=(D[i-1][j]+D[i-1][j-1])%mod;
                
            }
        }

        System.out.println(D[N][K]);
    }


}

