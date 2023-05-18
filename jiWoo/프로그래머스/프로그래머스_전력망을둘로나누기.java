package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_전력망을둘로나누기 {
    class Solution {
        public static boolean[][] checked;
        public static  LinkedList<Integer>[] tree;
        public int solution(int n, int[][] wires) {
            int min=Integer.MAX_VALUE;
            int answer = -1;
            // 연결리스트 초기화
            tree=new LinkedList[n+1];
            for(int i=0;i<n+1;i++){
                tree[i]=new LinkedList<>();
            }
            // 리스트에 연결 노드 넣기
            for(int i=0; i<n-1;i++){
                tree[wires[i][0]].add(wires[i][1]);
                tree[wires[i][1]].add(wires[i][0]);
            }

            // 노드들에 연결된 모든 노드들 한 번씩 끊어주기-> 근데 여기에 좀 별로인 거 확인해준거 두번씩 확인해주고있음 조건 추가해주고..싶지만 그냥 답이 맞길래 더 추가하기 귀찮음
            for(int i=1;i<=n;i++){
                for(int j:tree[i]){
                    checked=new boolean[n+1][n+1]; // checked는 연결된 송전탑 개수 구하기위해
                    checked[i][j]=true; // 서로 끊어졌으니까 true로 표시
                    checked[j][i]=true;
                    int r1=countNode(i); // i에 연결된 송전탑 개수
                    int r2=countNode(j); // j에 연결된 송전탑 개수
                    min=Math.min(min,Math.abs(r1-r2)); // 최소 구하기
                }
            }
            answer=min;
            return answer;
        }
        // node(nd)에 연결된 송전탑 개수 구하기
        public static int countNode(int nd){
            int result=1; // 자기 자신부터
            Queue<Integer> que=new LinkedList<>();
            // nd에 연결된 노드들 넣어주기
            for(int a:tree[nd]){
                if(checked[nd][a]==false){
                    result++;
                    que.add(a);
                    checked[nd][a]=true;
                    checked[a][nd]=true;
                }
            }
            // que에 넣어주며 노드들에 연결된 노드 que에 넣어주고 개수 check
            while(!que.isEmpty()){
                int now=que.poll();
                for(int a:tree[now]){ // 노드에 연결되ㅓ있고
                    if(checked[now][a]==false){ // 끊어져있거나, 벌써 체크해준 거 빼고
                        result++;
                        que.add(a);
                        checked[now][a]=true;
                        checked[a][now]=true;

                    }
                }
            }

            return result;
        }
    }
}
