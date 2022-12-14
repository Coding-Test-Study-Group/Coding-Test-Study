function solution(x) {
    var answer = true;
    const arr = x.toString().split("")
    let result = 0;
    for(let i=0;i<arr.length;i++){
        result += Number(arr[i]);
    }
    return x % result === 0 ? true : false;
}