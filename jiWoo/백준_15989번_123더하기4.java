
import java.util.*;

public class 백준_15989번_123더하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스
        int D[] =new int [10001];
        for(int i=0;i<=10000;i++) D[i]=1;
        // 2
        for(int i=2;i<=10000;i++){
            D[i]=D[i-2]+D[i];
        }
        // 3
        for(int i=3;i<=10000;i++){
            D[i]=D[i-3]+D[i];
        }
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(D[n]);
            
        }
    }
}
