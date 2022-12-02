// https://school.programmers.co.kr/learn/courses/30/lessons/12954
function solution(x, n) {
    var answer = [];
    const adder = x; // 값이 누적되지 않게 const 선언 해줍니다.
    
    // 문제 조건상 (n max = 1000) O(n)인 1차원 for문을 써도 1000ms가 넘지 않을겁니다. (컴퓨터는 초당 100000000회의 명령 수행)
    // 숫자도 마찬가지입니다. 평균 숫자하나당 4B-8B를 차지하므로 해당 없습니다.

    for (var i = 0; i < n; i++)
    {
        if (i === 0) // 첫번 째 숫자를 넣어줍니다.
        {
            answer.push(x); 
        }
        
        else
        {
            answer.push(x += adder); // adder랑 더한 값을 넣습니다.
        } 
    }
    return answer;
}

// 오늘은 좀 일정이 바빠서 우선 하나만 올리고 시간되면 하나 더 올리겠습니다