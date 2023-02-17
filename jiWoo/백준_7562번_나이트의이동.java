package jiWoo;
import java.util.*;
import java.io.*;
public class 백준_7562번_나이트의이동 {
    public static void main(String[] args) throws IOException{
        int [] dx={2,1,2,1,-1,-1,-2,-2};
        int [] dy={1,2,-1,-2,2,-2,-1,1};
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine()); // 테스트 케이스
        for(int i=0; i<T; i++){
            int I=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            // 현재 0에는 x, 1에는 y, 2에는 이동한 칸
            int [] now=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0};
            st=new StringTokenizer(br.readLine());
            // 이동하려고 하는 칸
            int [] night =new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            Queue<int []> que=new LinkedList<>(); // bfs
            boolean [][] visited=new boolean[I][I]; // 방문 확인
            que.add(now); // 현재 값 넣어주기
            while(!que.isEmpty()){
                int [] n=que.poll();
                int x=n[0]; int y=n[1]; int m=n[2];
                if(visited[x][y]) continue;// 방문했더라면 넘어가기
                if(x==night[0] && y==night[1]){ // 나이트가 이동하려는 칸이라면
                    System.out.println(m); // 이동한 칸 출력
                    break;
                }
                visited[x][y]=true; // 방문 확인해주고
                for(int j=0; j<8;j++){
                    int mx=x+dx[j]; int my=y+dy[j]; // 이동할 좌표
                    if(mx>=0 && my>=0 && mx<I && my<I && !visited[mx][my]){
                        que.add(new int[]{mx,my,m+1});
                    }
                }

            }
        }

    }


}
