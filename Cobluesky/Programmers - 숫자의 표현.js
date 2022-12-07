//https://school.programmers.co.kr/learn/courses/30/lessons/12924
//약수의 성질을 알아야합니다.
//연속된 수의 합의 개수는 해당 수의 약수 개수의 홀수와 같습니다.
function solution(n) {
    var answer = 0;
    
    for (var i = 0; i <= n; i++) // n 만큼 루프를 돌립니다.
    {
        if (n % i === 0 && i % 2 === 1) // 약수인지, 약수라면 홀수인지 체크합니다.
        {
            answer++;
        }
    }
    
    return answer;
}

// 제 생각에는, 전에 풀었던 방법처럼 n / 2만큼 loop를 돌린다음에 제곱수인 경우 따로 처리를 해서 값을 처리해주는게 더 빠를 것 같습니다.