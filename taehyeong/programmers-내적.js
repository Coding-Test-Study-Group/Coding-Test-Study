function solution(a, b) {
    /*
    방법1)
    let result = 0;
    for(let i=0; i<a.length; i++){
        result += a[i]*b[i];
    }
    return result;
    */
    //방법2
    return a.reduce((result,value,index)=>result += value*b[index],0);
}
