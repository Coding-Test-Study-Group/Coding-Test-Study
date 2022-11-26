function solution(arr) {
    var answer = 0;
    let result = 0;
    for(let i=0;i<arr.length;i++){
        result += arr[i];
        answer = result/arr.length
    }
    return answer;
} 