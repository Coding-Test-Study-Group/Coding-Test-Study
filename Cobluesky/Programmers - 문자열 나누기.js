//https://school.programmers.co.kr/learn/courses/30/lessons/140108
function solution(s) 
{
    var answer = 0;
    let firstLetter = ""; // 첫번째 문자 (기준이 될 문자)
    let firstLetterCnt = 0;
    let secondLetterCnt = 0;

    for (let letter of s) // for of loop (왠만하면 for보다 빠릅니다)
    {
        if (firstLetter === "") // firstLetter가 초기값이면 문자열 첫 글자와 같습니다.
        {
            firstLetter = letter;
        }

        if (firstLetter === letter) // 첫글자와 같으면 firstLetterCnt를 더합니다.
        {
           firstLetterCnt++;
        }

        else // 아닐경우엔 secondLetterCnt를 더합니다.
        {
            secondLetterCnt++;
        }

        if (firstLetterCnt === secondLetterCnt) // 같으면
        {
            answer++; // 문자열을 쪼갰다고 치고 answer를 더합니다.
            firstLetterCnt = 0; // 초기화합니다.
            secondLetterCnt = 0; // 초기화합니다.
            firstLetter = ""; // 초기화합니다.
        }
    }

    if (firstLetter != "") // loop가 끝났는데 firstLetter가 있으면 문자열이 아직 남은것으로 판단합니다.
    {
        answer++; // answer를 더합니다.
    }

    return answer;
}

// 실제로 문자열을 쪼개 새로운 배열이나 문자열을 만드는 것보다는 이게 빠르다고 판단했습니다.