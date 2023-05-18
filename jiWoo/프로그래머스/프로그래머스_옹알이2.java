package jiWoo.프로그래머스;

public class 프로그래머스_옹알이2 {
        public int solution(String[] babbling) {
            int answer = 0;
            // 가능한 발음 4개
            String[] pos = {"aya", "ye", "woo", "ma"};
            for (int i = 0; i < babbling.length; i++) {
                // 단어 하나씩 비교
                String now = babbling[i];
                boolean plus = true; // 발음 가능한 지 확인하기 위해서
                String check = "";   // 발음 중복 확인하기 위해서
                for (int j = 0; j < now.length(); j++) {
                    // 단어의 j 위치부터 발음 4개중에 가능한 것이 있는지 확인
                    boolean posCk = false; // 4가지 발음 가능한지 확인하기 위해서
                    for (int a = 0; a < 4; a++) {
                        // 단어 위치 j+가능한 발음의 길이 값 더한게 단어 길이보다 작고 && 중복 확인 && 단어의 위치에 pos가 있는지 확인
                        if (j + pos[a].length() <= now.length() && !pos[a].equals(check) && now.substring(j, j + pos[a].length()).equals(pos[a])) {
                            // 가능한 pos 찾았으므로 pos 찾기 반복문 나가기
                            check = pos[a]; // 중복 단어 확인을 위해 현재 확인한 발음 넣어주기
                            posCk = true;   // 4가지 발음 중 가능한지 확인
                            j = j + pos[a].length() - 1; // j의 위치를 가능한 단어 뒤로 넘겨주는데 j++을 생각해서 -1 해주기
                            break;
                        }
                    }
                    // 가능한 pos 없으면 now는 불가능
                    if (!posCk) {
                        plus = false;
                        break;
                    }
                }
                // 가능했다면 anwser++
                if (plus) answer++;
            }
            return answer;
        }
}
