function solution(price, money, count) {
    let cost = 0
    
    //이용 금액 구하기
    for(let i=1;i<=count;i++){
        cost += price*i
    }
    
    //삼항 연산자
    return cost > money ? cost - money : 0;
}