//https://school.programmers.co.kr/learn/courses/30/lessons/42746/
function solution(numbers) {
    var answer = '';
    
    let toString = numbers.map(num => num + ""); // map으로 string형 변환해줍니다.
    answer = toString.sort((a, b) => (b + a) - (a + b)).join(""); // 오름차순 정렬 후, join 문으로 합칩니다.
    
    if (answer[0] === "0") // 0일 경우 0을 반환합니다.
    {
        return "0";
    }
    
    return answer;
}