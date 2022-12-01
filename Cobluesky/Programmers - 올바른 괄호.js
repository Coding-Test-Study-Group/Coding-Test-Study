//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=javascript#
function solution(s)
{
    const stack = []; // 스택 구현합니다.
    
    if (!s.charAt(0) === "(") // 첫글자가 (로 시작하지 않으면 배제합니다.
    { 
        return false;
    }
    
    if (!s.charAt(s.length - 1) === ")") // 끝글자가 )로 끝나지 않으면 배제합니다.
    {
        return false;
    }
    
    for (const idx of s) // for of 루프입니다.
    {
        if (idx === '(') // (일 경우 스택에 집어넣습니다.
        {
            stack.push(idx);
        }
        
        else 
        {
            if (stack.length === 0) // stack에 아무것도 없으면 앞에 ( 괄호가 없는 것이므로 즉시 종료합니다.
            {
                return false;
            }
            
            stack.pop(); // )를 만날경우 스택의 마지막 값을 제거합니다.
        }
    }
    return stack.length === 0; // 계산이 끝났을 때 0이면 정상값, 아니면 이상값입니다.
}