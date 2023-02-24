function twoArrays(k, A, B) {
    // Write your code here
    /**
     * 문제가 아니라 예제를 보고 풀어야 하는 화가나는 유형
     * 조건1) A 배열은 오름차순으로 변형
     * 조건2) B 배열은 내림차순으로 변형
     * 조건3) 각 배열의 동일한 인덱스의 합은 k와 같거나 k보다 커야함
     */
  const a = A.sort((a, b) => a-b);
  const b = B.sort((a, b) => b-a);
  for(let i =0;i<a.length;i++){
      if(a[i]+b[i]<k)return "NO"
  }
  return "YES"
}