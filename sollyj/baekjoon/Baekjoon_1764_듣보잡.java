// Baekjoon_1764_듣보잡
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1764_듣보잡 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;

            // 듣도 못한 사람들 HashSet에 넣기
            // ArrayList로 contains를 사용하면 시간초과
            HashSet<String> notHearList = new HashSet<>();
            for(int i=0; i<N; i++) {
                notHearList.add(br.readLine());
            }

            // 듣도 보도 못한 사람들 배열리스트에 넣기
            ArrayList<String> notHearSeeList = new ArrayList<>();
            for(int i=0; i<M; i++) {
                String notSee = br.readLine();
                if(notHearList.contains(notSee)) {
                    count++;
                    notHearSeeList.add(notSee);
                }
            }
            Collections.sort(notHearSeeList);   // 사전순으로 출력하기 위해

            System.out.println(count);
            for(String s : notHearSeeList) {
                System.out.println(s);
            }
        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
