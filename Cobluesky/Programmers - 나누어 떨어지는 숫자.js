//https://school.programmers.co.kr/learn/courses/30/lessons/12910/
function solution(arr, divisor)
{
    var answer = [];

    for (const idx in arr) // for in이 왠만하면 빠릅니다.
    {
        if (arr[idx] % divisor === 0) // 나누기가 0인지?
        {
            answer.push(arr[idx]); // 배열에 추가
        }
    }

    if (answer.length === 0)
    {
       answer = [-1];
    }

    return answer.sort(function(a, b) {return a - b}); // 내림차순으로 sort합니다.
}
