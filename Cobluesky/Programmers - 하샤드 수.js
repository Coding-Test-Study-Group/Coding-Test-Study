// https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=javascript
function solution(x) 
{
    let firstNum = x; // x 초기값을 저장
    let sum = 0; // 합
    var answer = false; // 디폴트 값 설정 (true여도 무방)
    
    do // 최초 한 번 실행을 위해 do-while 작성
    {
        sum += x % 10; // 자리수 합산을 위해 나눗셈 후 합산
        x = Math.floor(x / 10); // 소숫점 절삭
    }
    
    while (x > 0);
    
    if (firstNum % sum === 0) // 나머지가 있는지?
    {
        answer = true;
    }
    return answer;
}

//0.03s, 33.4MB 입니다. 더 좋은 방법을 찾으신 분은 의견 공유 부탁드립니다.