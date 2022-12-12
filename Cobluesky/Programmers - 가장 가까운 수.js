//https://school.programmers.co.kr/learn/courses/30/lessons/142086
function solution(s) {
    var answer = [];
    var stack = []; // 한 번이라도 나온 문자를 저장합니다.
    
    for (const idx in s) // for in이 for보다 대부분 빠릅니다.
    {
        if (!stack.includes(s[idx])) // 나온적이 있는 문자인가?
        {
            answer.push(-1); 
            stack.push(s[idx]); // stack에 넣어줍니다.
        }
        
        else
        {
            answer.push(stack.length - stack.lastIndexOf(s[idx])); // 전체 길이에서 현재 인덱스를 뺀다면 idx 값을 얻을 수 있습니다.
            stack.push(s[idx]);
        }
    }
    
    return answer;
}