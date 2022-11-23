//https://school.programmers.co.kr/learn/courses/30/lessons/136798
function solution(number, limit, power) 
{
    let numberArr = []; // 약수 개수 배열
            
    for (let i = 1; i <= number; i++) // number만큼 loop
    {
        let cnt = 0; // 약수 개수
        for (let j = 1; j * j <= i; j++) // number[i] 만큼 돌아야합니다. 다만, i만큼 돌면 시간복잡도가 너무 높아 통과할 수 없습니다. 따라서 약수의 성질을 이용해 시간복잡도를 O(Sqrt(n))으로 낮춥니다. 이를 위해 제곱근 체크를 (n * n) 으로 대행합니다.
        {   
            if (i % j === 0) // 약수인가?
            {
                cnt++;    
        
                if (j * j < i) // 제곱수인가?
                {
                    cnt++; 
                }        
            }
        }
    
        if (cnt > limit) // 약수의 개수가 limit를 초과할 경우
        {
            cnt = power; // 파워와 같다
        }

        numberArr.push(cnt); // 배열에 삽입
    }
    let answer = numberArr.reduce(function add(sum, value) {return sum + value;}); // 배열의 합 계산
    return answer;
}

