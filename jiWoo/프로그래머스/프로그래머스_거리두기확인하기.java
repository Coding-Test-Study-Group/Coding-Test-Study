package jiWoo.프로그래머스;

import java.util.*;
public class 프로그래머스_거리두기확인하기 {
    public static int [] dx={-1, 1, 0, 0}; //4방향
    public static int [] dy={0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int len=places.length;
        int[] answer = new int[len]; // 답
        // len만큼 거리두기 확인하기
        for(int i=0; i<len; i++){
            answer[i]=1; // 초기값은 모든 응시자가 거리두기 지키고 있다고 가정한다.
            char[][] map=new char[5][5]; // 대기실

            for(int j=0; j<5; j++){
                map[j]=places[i][j].toCharArray(); // 5*5 char 배열로 만들어주기
            }
            Queue<int[]> p_que=new LinkedList<>();// int[0]: x, int[1]: y, int[2]: P가 움직인 거리
            // 배열에서 P가 있는 곳 p_que에 넣기
            for(int a=0; a<5; a++){
                for(int b=0; b<5; b++){
                    if(map[a][b]=='P') p_que.add(new int[]{a,b,0});
                }
            }
            boolean [][] visited=new boolean[5][5]; // 시작 P만 체크
            Queue<int[]> que=new LinkedList<>();// que에 p부터 깊이 2까지 탐색, int[0]: x, int[1]: y, int[2]: P가 움직인 거리
            //BFS
            loop:
            while(!p_que.isEmpty()){
                if(que.isEmpty()){ // que가 비면 새로운 P를 넣어준다.
                    que.add(p_que.poll());
                }
                int [] now=que.poll();

                if(now[2]==0){ // 현재가 시작 P
                    visited=new boolean[5][5]; // 시작 P만 체크
                    visited[now[0]][now[1]]=true; // 시작 P로 돌아가지 않기 위해서
                }

                for(int j=0; j<4; j++){ //try catch는 범위 넘어간 에러 주의하려고
                    try{
                        int nx=now[0]+dx[j]; int ny=now[1]+dy[j]; // 1칸 이동

                        if(map[nx][ny]=='P'&& !visited[nx][ny]){ // 2칸이내에 P를 만났을 때(시작 P가 아닐 때)
                            answer[i]=0;
                            break loop; // 현재 BFS 종료
                        }else if(map[nx][ny]!='X' && now[2]+1==1) que.add(new int[]{nx,ny,now[2]+1}); // X로는 가지 않고 2를 넘으면도 가지 않는다.
                    }catch(Exception e){
                    }
                }
            }
        }
        return answer;
    }

}
