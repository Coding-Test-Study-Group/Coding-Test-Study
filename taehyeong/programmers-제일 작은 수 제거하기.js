function solution(arr) {
    let answer = [];
    let min = Number.MAX_SAFE_INTEGER;
    
    for(let i=0; i<arr.length;i++){
        if(arr[i]<min) min = arr[i]
    }
    del = arr.findIndex((data)=> {return data === min})
    arr.splice(del,1)
    arr.length === 0 ? answer.push(-1) : answer = arr
    
    return answer;
}