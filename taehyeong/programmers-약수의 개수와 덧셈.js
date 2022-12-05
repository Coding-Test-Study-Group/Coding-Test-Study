function solution(left, right) {
    let count = 0;
    for(let i=left;i<=right;i++){ //left와 right값의 사이의 숫자를 구합니다.
        let array = []
        for(let j=1;j<=i;j++){ //left에서 right값의 숫자들의 약수를 구합니다.
            if(i % j === 0){
                array.push(j)
            }
        }
        array.length % 2 === 0 ? count += i : count -= i
    }

    return count;
}