//https://school.programmers.co.kr/learn/courses/30/lessons/12926
function solution(s, n) 
{
    const upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Upper Case 문자열입니다.
    const lower = "abcdefghijklmnopqrstuvwxyz"; // Lower Case 문자열입니다.
    var answer = '';

    for (const idx in s) // for in loop
    {
        let singleText = s[idx]; // 현재 위치한 텍스트입니다.

        if (singleText === " ") // 공백이면
        {
            answer = answer + " " // 공백을 추가합니다.
            continue; // 계속합니다.
        }

        if (upper.includes(singleText)) // 대문자인가?
        {
            let upperIdx = upper.indexOf(singleText); // 대문자배열에서 위치를 찾습니다.
            let modUpperIdx = upperIdx + n; // n만큼 밀기

            if (modUpperIdx >= upper.length) // Z보다 크면
            {
               modUpperIdx = modUpperIdx - upper.length; // 차를 구해 집어넣습니다.
            }

            let answerText = upper[modUpperIdx];
            answer = answer + answerText; // 구한 값을 더합니다.
        }

        else
        {
            let lowerIdx = lower.indexOf(singleText);
            let modLowerIdx = lowerIdx + n;

            if (modLowerIdx >= lower.length)
            {
                modLowerIdx = modLowerIdx - lower.length;
            }

            let answerLowerText = lower[modLowerIdx];
            answer = answer + answerLowerText;
        }
    }

    return answer;
}