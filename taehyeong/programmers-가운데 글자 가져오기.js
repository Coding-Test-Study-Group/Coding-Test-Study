function solution(s) {
    var answer = '';

    //방법 1
    /*
       let arr = s.split(""); //문자열을 배열로 변환
       let idx = Math.round(arr.length/2) -1; //배열의 길이가 홀수 일 경우를 대비해 Math객체 사용
    
       if(arr.length % 2 === 0){ //배열이 짝수일 경우
           answer = arr[idx]+arr[idx+1] 
       }else{ //배열이 홀수일 경우
           answer = arr[idx]
       }
    */
 
    //방법 2
    answer = s.substr(Math.ceil(s.length / 2) -1 ,s.length % 2 === 0 ? 2: 1);
    
    return answer;
}