package jiWoo;
import java.util.*;
public class 프로그래머스_과제진행하기 {
    public String[] solution(String[][] plans) {
        // hashMap에는 해당 과제의 남은 시간을 넣어준다.
        HashMap<String, Integer> map = new HashMap<>();

        int len = plans.length;
        String[] answer = new String[len];

        // 끝난 과제의 수(answer에 넣어줄 때 사용)
        int stopCnt = 0;

        // map에 과제명과 과제 수행 시간을 넣는다.
        for (String[] plan : plans) {
            map.put(plan[0], Integer.parseInt(plan[2]));
        }

        // 멈춰둔 과제 넣기
        // 가장 최근에 멈춘 과제부터 시작하기 위하여 Stack 사용
        Stack<String> sk = new Stack<>();


        // plans를 start(과제 시작) 순으로 정렬하기
        Arrays.sort(plans, (o1, o2) -> o1[1].toString().compareTo(o2[1].toString()));

        // 과제 수행
        // 다음 과제까지 남은 시간 안에 과제를 수행하면 끝내고 멈춘 과제를 수행하고 아니면 멈춘 과제에 넣어준다.
        for (int i = 0; i < len; i++) {
            // 다음 플랜까지 남은 시간(현재 과제를 수행할 수 있는 시간)
            // 마지막 과제는 다음 과제가 없으므로 현재 걸리는 시간을 넣어준다.
            int time = (i != len-1) ? getTime(plans[i][1].split(":"), plans[i+1][1].split(":")) : Integer.parseInt(plans[i][2]);

            // minusTime은 현재 playtime - time(수행 가능한 시간)
            int minusTime = Integer.parseInt(plans[i][2]) - time;

            // 남은 시간이 있다면
            if (minusTime > 0) {
                // 멈춘 스택에 넣어주기
                // map에 남은 시간 수정해주기
                sk.add(plans[i][0]);
                map.put(plans[i][0], minusTime);
            }
            // 남은 시간이 양수가 아니라면(현재 과제를 수행 가능)
            else if (minusTime <= 0) {
                // 답에 넣어주고 index를 늘려준다.
                answer[stopCnt] = plans[i][0];
                stopCnt++;
                // 전 플랜이 더 빨리 끝났다면 minuesTime이 0일 때까지 멈춘 플랜들을 수행한다.
                while (minusTime != 0 && !sk.isEmpty()) {
                    // 가장 최근에 멈춘 과제를 꺼낸다.
                    String stop = sk.pop();
                    int stopTime = map.get(stop);
                    // 꺼낸 멈춘 과제를 시간 안에 수행할 수 있다면 답에 넣어주고 minusTime에 더해준다.
                    if (minusTime * (-1) >= stopTime) {
                        answer[stopCnt] = stop;
                        stopCnt++;
                        minusTime += stopTime;
                    } else {
                        // 수행할 수 없다면 멈춘 과제를 가능한 시간만큼 수행하고 다시 stack에 넣어준다.
                        // 이때 hashMap의 남은 시간도 수정
                        sk.add(stop);
                        map.put(stop, stopTime - minusTime * (-1));
                        minusTime = 0;
                    }
                }
            }

        }
        // 마지막 과제까지 끝난 후 stack에 남아있는 멈춘 과제를 최신 순으로 답에 넣어준다.
        while(!sk.isEmpty()) {
            answer[stopCnt] = sk.pop();
            stopCnt++;
        }

        return answer;
    }

    // now 플랜과 다음 next 플랜 사이의 가능한 시간
    public int getTime(String[] now, String[] next) {
        //System.out.println(next[0] + next[1] +" " +now[0] + now[1]);
        int minute = Integer.parseInt(next[1]) - Integer.parseInt(now[1]);
        boolean check = false;
        if (minute < 0) {
            check = true;
            minute += 60;
        }

        int hour = Integer.parseInt(next[0]) - Integer.parseInt(now[0]);
        if(check) hour--;

        return hour * 60 + minute;
    }
}
