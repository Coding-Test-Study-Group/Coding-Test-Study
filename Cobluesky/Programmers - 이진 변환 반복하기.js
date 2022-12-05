//https://school.programmers.co.kr/learn/courses/30/lessons/70129
//우선, 별로 효율적이지 못한 풀이입니다.
function solution(s) 
{
    var answer = [];
    
    let zeroCnt = 0; // 0의 숫자입니다.
    let transCnt = 0; // 변환한 횟수입니다.
    
    const deleteZero = (s) =>  // 처리하는 함수이긴한데.. 필요가 없습니다.
    {
        while (s.length !== 1) // 저는 주어진 s 문자열을 판단기준으로 삼았으므로 s의 길이 조건을 겁니다.
        {
            var count = 0; // 0 개수입니다.
            var pos = s.indexOf(0); // 0 개수 세기를 위한 position 변수입니다.

            while (pos !== -1) { // 0 개수 세기를 위한 loop
              count++;
              pos = s.indexOf(0, pos + 1);
            }

            zeroCnt += count; // 0 개수 저장

            let length = s.replace(/0/g, '').length; // 이진 변환을 위한 0 절삭, 길이 처리입니다.
            s = length.toString(2); // 길이를 2진 변환
            transCnt++; // 변환 횟수 + 1
        }
        answer.push(transCnt); // 배열에 저장
        answer.push(zeroCnt);
    }
    
    deleteZero(s);
    
    return answer;
}

//맨 처음에 접근을 잘못해서 함수로 만들었는데, 굳이 필요가 없습니다.
//테스트를 통과하긴 하지만 시간복잡도 측면에서 좋은 풀이는 아닙니다.