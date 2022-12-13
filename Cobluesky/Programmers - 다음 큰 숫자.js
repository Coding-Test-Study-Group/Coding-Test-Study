//https://school.programmers.co.kr/learn/challenges?order=acceptance_desc&page=3&levels=2%2C1&languages=javascript
function solution(n) 
{
    var answer = 0; 
    var counter = n + 1; // n보다 큰 수 입니다.
    var nToBinaryCount = n.toString(2).match(/1/g).length; // 2진수로 전환한 후 정규식으로 1의 개수를 셉니다.
    
    while (true) // 효율성을 위해 while 사용
    {
        if (counter.toString(2).match(/1/g).length == nToBinaryCount) // 2진 변환시 1 개수가 같은지 체크합니다.
        {
            return counter;
        }
        
        else
        {
            counter++; // 아닐 경우 n보다 큰 수에 1을 더합니다.
        }
    }
}