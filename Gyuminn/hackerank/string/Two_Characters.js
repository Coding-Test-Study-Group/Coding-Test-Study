function alternate(s) {
  // 가능한 조합 - 2개의 문자로 이루어진 2차원 배열이 들어갈 예정
  const combination = [];

  // 조합을 만들기 위한 방문 노드 대신 Set 만들기
  const stringSetArr = [...new Set(s)];

  // DFS에서 조합을 저장할 임시 배열
  const temp = Array.from({ length: 2 }, () => 0);

  // dfs를 통해 가능한 조합 찾기
  const dfsForComb = (L, S) => {
    if (L === 2) {
      combination.push(temp.slice());
      return;
    }

    for (let i = S; i < stringSetArr.length; i++) {
      temp[L] = stringSetArr[i];
      dfsForComb(L + 1, i + 1);
    }
  };
  dfsForComb(0, 0);

  // 문자열을 배열로 생성
  const stringArr = [...s];

  // 최대 길이를 0으로 초기화
  let maxLen = 0;

  combination.forEach((comb) => {
    // 가능한 조합을 순회하면서
    // 그 조합의 문자열 2개를 포함하는 배열요소들만 반환 후
    // join을 통해 문자열로 변환
    const test = stringArr.filter((char) => comb.includes(char)).join("");

    // 이 정규식 /(.)\1/ 은 반복되는 문자를 찾는데 사용된다.
    // 여기서 괄호 안에 있는 . 은 어떤 문자든지 일치하고,
    // \1은 첫 번째 괄호 안의 내용과 일치한다.
    // 즉, 이 정규식은 어떤 문자가 다시 그 다음에 반복되는 패턴을 찾습니다.
    if (test.match(/(.)\1/) === null) {
      maxLen = Math.max(maxLen, test.length);
    }
  });

  return maxLen;
}

console.log(alternate("beabeefeab"));
