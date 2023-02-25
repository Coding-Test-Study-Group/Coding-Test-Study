function birthday(s, d, m) {
    // Write your code here
    let answer = 0;
    for(let i =0; i<s.length;i++){
       let setArr = s.slice(0+i, m+i);
       console.log(setArr);
       let segments = setArr.reduce((sum,now)=>sum+now,0)
       if(segments===d) answer++;
    }
    return answer
}