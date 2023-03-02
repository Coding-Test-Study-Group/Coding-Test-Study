// https://www.hackerrank.com/challenges/strong-password/problem?isFullScreen=true

function minimumNumber(n, password) {
  let cnt = 0;

  const numRegex = /[0-9]/;
  const lowerCaseRegex = /[a-z]/;
  const upperCaseRegex = /[A-Z]/;
  // hypen의 경우 범위로 표시될 수 있기 때문에 역슬래쉬 추가
  const specialCharRegex = /[!@#$%^&*()\-+]/;

  if (!numRegex.test(password)) cnt++;
  if (!lowerCaseRegex.test(password)) cnt++;
  if (!upperCaseRegex.test(password)) cnt++;
  if (!specialCharRegex.test(password)) cnt++;
  while (n + cnt < 6) cnt++;

  return cnt;
}
