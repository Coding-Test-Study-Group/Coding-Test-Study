// baek1448
import java.util.*;
import java.io.*;

public class triangle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N];
        boolean flag = false;

        for(int i=0; i<N; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(length);    // 오름차순 정렬
        
        int maxLength;
        int secLength;
        int thirdLength;

        for(int i=N-1; i>=2; i--) { // 역순으로 가장 큰 세개의 값만 비교한다. (그리디 알고리즘)
            maxLength = length[i];
            secLength = length[i-1];
            thirdLength = length[i-2];

            if(maxLength < secLength + thirdLength) {
                System.out.print(maxLength+secLength+thirdLength);
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.print("-1");
        }
    }
}
