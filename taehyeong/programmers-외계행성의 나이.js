function solution(age) {
    var answer = '';
    arr = ["a","b","c","d","e","f","g","h","i","j"]
    arr2 = String(age).split("")
    for(let i=0;i<arr2.length;i++){
        answer += arr[arr2[i]]
    }
    
    return answer;
}