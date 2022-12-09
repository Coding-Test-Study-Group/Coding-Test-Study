function solution(s, n) {
    let CodeArr = [];
    for(let i=0;i<s.length;i++){
        let Acode = s.charCodeAt(i);
        console.log(Acode)
        //소문자일 경우
        if(Acode > 96 && Acode < 123){
            Acode + n > 122 ? CodeArr.push((Acode + n) - 26) : CodeArr.push(Acode+n)
        }
        //대문자일 경우
        if(Acode > 64 && Acode < 91){
            Acode + n > 90 ? CodeArr.push((Acode + n) - 26) : CodeArr.push(Acode+n) 
        }
        //공백일 경우
        if(Acode === 32){
            CodeArr.push(Acode)
        }        
    }
    return String.fromCharCode(...CodeArr)
}