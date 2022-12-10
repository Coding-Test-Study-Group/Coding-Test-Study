function solution(array, height) {   
    return (array.filter(v=> height<v)).length
}