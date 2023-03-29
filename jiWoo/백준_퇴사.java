package jiWoo;

import java.util.*;
import java.io.*;

public class 백준_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 퇴사 전까지 남은 N일
        // 상담 일정표 plan[i][0]: i일 상담의 걸리는 기간 T, plan[i][1]: i일 상담의 금액 P
        int [][] plan=new int[N+1][2]; // 1일부터 N일까지 확인위해 N+1
        for(int i=1; i<N+1; i++){
            st=new StringTokenizer(br.readLine());
            plan[i][0]=Integer.parseInt(st.nextToken());
            plan[i][1]=Integer.parseInt(st.nextToken());
        }

        int D[]=new int[N+2]; // 다이나믹 프로그래밍 사용, i일까지의 최대 수익, N+1일(퇴사까지 비교)
        for(int i=1; i<N+1; i++){
            int T=plan[i][0]; // i일 상담의 걸리는 시간
            int P=plan[i][1]; // i일 상담의 금액

            if(i+plan[i][0]<=N+1){ // 오늘 상담이 퇴사 전까지 끝나는지 확인
                // i일의 상담을 들었을 때
                // D[i+T]=D[i+T]와 오늘까지의 최대값 D[i]+P 비교해서 큰 값 넣어주기
                D[i+T]=Math.max(D[i+T],D[i]+P);
            }
            // i+1날의 값에 i+1날의 최대 수익과 오늘까지의 최대 수익 비교해서 넣어주기
            D[i+1]=Math.max(D[i+1],D[i]);
        }
        // 퇴사날의 최대값 출력!
        System.out.println(D[N+1]);
    }
}
