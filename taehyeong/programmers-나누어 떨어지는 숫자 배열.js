function solution(arr, divisor) {
    var answer = [];
    for(let i=0; i<arr.length; i++){
        if(arr[i] % divisor === 0){
            answer.push(arr[i])
        }
    }
    answer.sort((a, b)=> {
      return a-b; //오름차순, return b-a 내림차순
    });
    if(answer.length === 0){
        answer.push(-1)
    }
    return answer;
} 