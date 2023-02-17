package jiWoo;
import java.io.*;
import java.util.*;
public class 백준_1697번_숨바꼭질 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        Queue<int []> que=new LinkedList<>();
        que.add(new int[]{N,0});
        boolean [] visited=new boolean[100001];
        while(!que.isEmpty()){
            int [] now=que.poll();
            int loc=now[0]; int time=now[1];
            if(visited[loc]) continue; // 확인했던거면 넘어가기
            visited[loc]= true; // 확인해주기
            if(loc==K){ // 동생 찾았을 때! 나가기
                System.out.println(time);
                break;
            }else{
                if(loc-1>=0 && !visited[loc-1]) que.add(new int[]{loc-1,time+1});
                if(loc+1<=100000 && !visited[loc+1]) que.add(new int[]{loc+1,time+1});
                if(loc*2<=100000 && loc!=0 && !visited[loc*2]) que.add(new int[]{loc*2,time+1});
            }

        }
    }
}
