//https://school.programmers.co.kr/learn/courses/30/lessons/42885
function solution(people, limit) { 
    var answer = 0;

    people.sort((a, b) => b - a); // 정렬

    let start = 0; // 시작 idx 
    let end = people.length - 1; // 끝지점 idx

    while (start < end) 
    {
        var sum = people[start] + people[end]; // limit를 넘나?
        if (sum > limit)
        {
            start++; // 넘으면 보낸셈치고 idx 뒤로 하나
        }

        else
        {
            start++; // 넘지 않으면 2명 보낸거므로...
            end--; // 시작하나 밀고, 끝도 하나 당긴다.
        }
        answer++; // 하나 보냄
    }

    if (start === end) // 마지막 하나
    {
        answer++; 
    }

    return answer;
}