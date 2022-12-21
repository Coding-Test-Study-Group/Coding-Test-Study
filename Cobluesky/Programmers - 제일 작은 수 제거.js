//https://school.programmers.co.kr/learn/courses/30/lessons/12935
function solution(arr) 
{   
    if (arr.length > 1) // 배열의 개수가 하나 인가?
    {
        var minValue = Math.min(...arr); // 최솟값 찾기 (전개 연산자)
        var index = arr.indexOf(minValue); // 최솟값 인덱스 찾기
        arr.splice(index, 1); // 최솟값 제거
    }
    
    else
    {
        arr = [-1];
    }
    return arr;
}