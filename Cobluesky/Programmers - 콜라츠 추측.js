//https://school.programmers.co.kr/learn/courses/30/lessons/12943
function solution(num) {
    var answer = 0;

    while (num !== 1) // 숫자가 1인가?
    {
        if (answer === 500) // count가 500인가?
        {
            return -1;
        }

        if (num % 2 === 0) // 짝수인가?
        {
            num = (num / 2);
            answer++;
        }

        else // 홀수인가?
        {
            num = (num * 3) + 1;
            answer++;
        }
    }
    return answer;
}

// 대체로 for보다는 while이 빠릅니다.
// for each를 쓸 수 있으면 for each가 무조건 빠릅니다만 for each는 object만 사용이 가능합니다.
// 제 생각에는 시간복잡도가 괜찮게 나온 것 같습니다.