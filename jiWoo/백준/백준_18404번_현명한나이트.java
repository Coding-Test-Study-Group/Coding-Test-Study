package jiWoo.백준;

import java.io.*;
import java.util.*;

public class 백준_18404번_현명한나이트 {
    // 체스 말이 이동할 수 있는 범위
    static int dx[]={-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[]={-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][] visited; // 방문 확인
    static int[][] theOther; // 적들
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // N x N 체스판
        int M=Integer.parseInt(st.nextToken()); // M개의 상대편 말

        // 나의 위치
        st=new StringTokenizer(br.readLine());
        int X=Integer.parseInt(st.nextToken())-1;
        int Y=Integer.parseInt(st.nextToken())-1;

        // 상대편 말들 배열에 넣어주기
        theOther=new int[N][N];
        for(int i=1; i<=M; i++){
            st=new StringTokenizer(br.readLine());
            // 상대편 말의 인덱스로 말의 위치 표시, -1은 배열에 맞추기위해 해줌
            theOther[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=i;
        }

        // 상대방 말 BFS로 탐색하여 최소 이동 수 계산
        visited=new boolean[N][N]; // 방문 확인을 위한

        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{X,Y,0}); // 시작하는 나의 위치와 이동 수 넣어주기
        int[] result=BFS(M,que); // 목표 상대방 위치 X, Y와 que 넣어주기

        for(int i:result){ // 답 출력
            System.out.print(i+" ");
        }

    }
    // 적들을 찾기위해 BFS를 M번 돌리는 것이 아니라 움직이며 적을 찾아줘 시간 초과 방지! 방문 확인 주의!
    // 적을 찾아도 다른 적을 찾을 때까지 que에 넣어 돌려줘야한다.
    public static int[] BFS(int cnt, Queue<int[]> que){
        int[] answer=new int[cnt];

        while(cnt>0){ // 말을 다 찾을 때까지
            int [] now=que.poll();
            int nx=now[0];
            int ny=now[1];

            if(visited[nx][ny]) continue; // 방문했다면 check 해준 것이므로 다음 노드
            visited[nx][ny]=true; // 방문 확인

            for(int i=0; i<8; i++){
                // 이동한 좌표
                int mx=nx+dx[i];
                int my=ny+dy[i];
                if(mx>=0 && my>=0 && mx<N && my<N) { // 범위 체스판 안에
                    if (visited[mx][my])
                        continue; // 여기서도 한 번 더 방문 확인
                    // 이동한 좌표가 목표 좌표인지 확인
                    if (theOther[mx][my]>0) { // 적에 index 넣어줬으므로 확인!
                        answer[theOther[mx][my]-1]=now[2]+1; // theOther[mx][my]-1: 인덱스 배열에 맞춰서 -1, 이동한 수 넣어주기
                        theOther[mx][my]=0; // 확인했다고 바꿔주기
                        cnt--;
                    }
                    que.add(new int[] {mx, my, now[2] + 1}); // que에 넣어주기
                }
            }
        }
        return answer;// 항상 도달해서 실패할 일 없음
    }
}
