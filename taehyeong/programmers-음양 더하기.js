function solution(absolutes, signs) {
    var answer = 0;
    
    for(let i=0;i<signs.length;i++){
        /*
        방법1) for문을 이용한 풀이
        if(signs[i] === true){
            answer += absolutes[i]
        }else if(signs[i] === false){
            answer += -(absolutes[i])
        }
        */
        //방법2) 논리연산자를 이용한 풀이
        signs[i] === true ? answer += absolutes[i] : answer += -(absolutes[i])
        
    }
    
    return answer;
}