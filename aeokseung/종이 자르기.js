function solution(M, N) {
  var answer = 0;
  //M과 N이 같을 때와 다를 때로 나눠서 풀이
  if (M === N) {
    //정사각형인 경우
    answer = M * M - 1;
  } else {
    //직사각형인 경우
    answer = M - 1 + M * (N - 1);
  }
  return answer;
}
