package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_오픈채팅방 {
    // 해당 아이디에 닉네임을 저장하기 위해 hashMap 사용
    static HashMap<String, String> map=new HashMap<>();
    public String[] solution(String[] record) {
        int size=record.length;
        // 들어오고 나간 것 기록하기 위해 Queue 사용
        Queue<String[]> que=new LinkedList<>();
        // record를 읽으며
        // 1) Enter이면 닉네임 map에 넣어주고, que에 Enter와 아이디 넣고
        // 2) Change이면 닉네임 map에 다시 넣기
        // 3) Leave이면 que에 Leaved와 아이디 넣는다
        for(int i=0; i<size; i++){
            String[] rarr=record[i].split(" ");
            if(rarr[0].equals("Enter")){
                map.put(rarr[1],rarr[2]);
                que.add(new String[]{rarr[0],rarr[1]});
            }else if(rarr[0].equals("Leave")){
                que.add(new String[]{rarr[0],rarr[1]});
            }else{
                map.put(rarr[1],rarr[2]);
            }
        }
        int qsize=que.size();
        String answer[] =new String[qsize];
        // que에서 빼며 Enter와 Leave를 구별하며 해당 아이디에 닉네임을 map에서 꺼내서 넣어준다.
        for(int i=0; i<qsize; i++){
            String[] now=que.poll();
            if(now[0].equals("Enter")){
                answer[i]=map.get(now[1])+"님이 들어왔습니다.";
            }else{
                answer[i]=map.get(now[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }

}
