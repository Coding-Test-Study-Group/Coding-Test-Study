//https://school.programmers.co.kr/learn/courses/30/lessons/12981/solution_groups?language=javascript&type=my
function solution(n, words) 
{
    let answer = [0, 0]; // 정답 초기화
  
    for (let idx = 0; idx < words.length; idx++) // words length 만큼 loop
    {
      let word = words[idx]; // 비교용으로 변수에 담음
      let p = idx % n + 1; // 현재 누구 차례인가?
      let turn = Math.ceil((idx + 1) / n); // 누구의 몇번째 차례인가?
  
      if (idx > 0) 
      {
        let last = words[idx - 1].split("").pop(); // 이전 단어의 마지막 글자
  
        if (idx > words.indexOf(word) || words[idx][0] !== last) // 이미 나온 단어 또는 잘못된 단어로 시작
        {
          answer = [p, turn]; // 답을 return
          break;
        }
      }
    }
  
    return answer;
  }