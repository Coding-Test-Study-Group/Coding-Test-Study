package jiWoo;

import java.util.*;
public class 프로그래머스_단어변환 {
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static boolean checked [];
    static String tar;
    static String[] ws;
    static PriorityQueue<Integer> pr = new PriorityQueue<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        tar = target;
        ws = words;
        // HashMap에 각 단어가 한글자만 다른 단어들을 넣어놓기 위하여
        map.put(begin, new ArrayList<String>());
        // map에 각 단어들을 넣으면서 findWords 메서드를 이용해서 한글자만 다른 단어들을 map에 넣어줬다.
        for (String w : words) {
            map.put(w, new ArrayList<String>());
            findWords(w.toCharArray(), words);
        }
        // 시작 단어도 넣어줌.
        findWords(begin.toCharArray(), words);
        // 방문 체크
        checked = new boolean[words.length];
        // dfs
        dfs(begin, 0);
        // 변환 과정 중 제일 짧은 수 찾아줌
        if (pr.size() != 0) answer = pr.poll();
        return answer;
    }

    // map에 있는 단어들을 방문 확인하여 dfs
    public void dfs(String w, int cnt) {
        ArrayList<String> list = map.get(w);
        cnt++;
        for (String s : list) {

            int idx = Arrays.asList(ws).indexOf(s);

            if (s.equals(tar)) {

                pr.add(cnt);
            }
            else if (checked[idx]) continue;
            else {
                checked[idx] = true;
                dfs(s, cnt);
                checked[idx] = false;
            }
        }

    }

    // 한글자만 다른 단어들 찾아주기
    // 유의할 점 index로 확인해서 한글자만 다른 거 찾아주기
    public void findWords(char[] array, String[] words) {
        int len = array.length;
        int count = 0;
        for (String w : words) {
            count = 0;
            if (w.equals(String.valueOf(array))) continue;
            for (int i = 0; i < len; i++) {
                if (w.charAt(i) == array[i]) count++;
            }

            if (count == (len-1)) {
                ArrayList<String> list = map.get(String.valueOf(array));
                list.add(w);
                map.put(String.valueOf(array), list);
            }
        }
    }
}
