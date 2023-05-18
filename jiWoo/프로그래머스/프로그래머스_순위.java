package jiWoo.프로그래머스;

import java.util.*;
public class 프로그래머스_순위 {
    static boolean[] visited;
    // 위너들이 이긴 사람(loser) 넣어놓은 리스트
    static ArrayList<Integer>[] winner;
    public int solution(int n, int[][] results) {
        int answer = 0;
        visited=new boolean[n+1];
        winner=new ArrayList[n+1];
        for(int i=0; i<=n; i++) //
            winner[i]=new ArrayList<>();
        // results에 있는 결과 넣어주기 result[i][0]: 승자 result[i][1] 패자
        int len=results.length;
        for(int i=0; i<len; i++){
            winner[results[i][0]].add(results[i][1]);
        }

        // DFS를 사용하여 승자에 패자 리스트 전부 채워주기
        for(int i=1; i<=n; i++){
            visited=new boolean[n+1];
            winner[i]=DFS(i,new ArrayList<Integer>());
        }

        // winner[i]에는 각 선수별 탐색할 수 있는 모든 패자들을 넣어주었다.
        // 정확하게 순위를 매길 수 있는 선수는 이긴 수 + 진 수 = n-1여야 한다.
        int [] cnt=new int[n+1];

        for(int i=1; i<=n; i++){
            // i 이긴 수 체크
            cnt[i]+=winner[i].size(); // i 의 패자리스트의 개수 더해주기
            // i의 패자리스트에 값-> j의 진 수 체크

            for(int j:winner[i]){
                cnt[j]++; // j는 i에게 졌으므로 cnt[j]++
            }
        }

        // cnt[i]=n-1일 때 정확하게 순위 매길 수 있다.
        for(int sum:cnt){
            if(sum==(n-1))answer++;
        }

        return answer;
    }

    public static ArrayList<Integer> DFS(int i, ArrayList<Integer> li){
        // 위너의 패자를 탐색하며 그 패자의 패자들을 넣어주기 위한 DFS
        for(int loser:winner[i]){

            if(!visited[loser]){
                visited[loser]=true;
                li.add(loser);
                DFS(loser,li);
            }
        }
        return li;
    }
}
