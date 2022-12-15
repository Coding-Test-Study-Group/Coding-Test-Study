function solution(n) {
//     var answer = 0;
//     const number = String(n).split()
//     const result = number[0].split("").sort(function(a,b){
//         return b-a
//     })
    
//     let last = "";
//     for(let i =0; i<result.length; i++){
//         last += result[i]
//     }

//     answer = parseInt(last)
    
    return parseInt(n.toString().split('').sort((a,b)=>b-a).join('')) 
}