package jiWoo;
import java.util.*;
public class 백준_14502번_연구소 {
    public static int max=0;
    public static int N,M;
    public static int[][] arr;
    public static int dx[] = new int[]{0, 0, 1, -1};
    public static int dy[] = new int[]{1, -1, 0, 0};

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        arr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        wall(0);
        System.out.println(max);

    }

    public static void wall(int idx){
        if(idx==3){
            // 벽에 3개라면
            int countZero=bfs();
            max=Math.max(max,countZero);
            return;
        }

        // 벽이 3개 이하라면 벽을 세운다
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    wall(idx+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    // 바이러스가 퍼졌을 때
    public static int bfs(){
        Queue<int []> que=new LinkedList<>();
        boolean[][] check=new boolean[N][M];
        // 2인 위치를 bfs의 시작위치로

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==2){
                    que.add(new int[]{i,j});
                    check[i][j]=true;
                }
            }
        }

        while(!que.isEmpty()){
            int list[]=que.poll();
            int x=list[0];
            int y=list[1];

            for(int i=0;i<4;i++){
                // 4방향 2 주변이 0이변 체크해주기
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == false && arr[nx][ny] == 0) {
                    check[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }

            }
        }
        // 0이고 false인 곳 찾기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && check[i][j] == false) {
                    count++;
                }
            }
        }
        return count;


    }
}
