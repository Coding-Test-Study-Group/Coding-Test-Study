// https://www.hackerrank.com/challenges/caesar-cipher-1/problem

function caesarCipher(s, k) {
  let result = "";

  for (let i = 0; i < s.length; i++) {
    // 문자를 아스키코드로 변환
    let ASCIICode = s[i].charCodeAt();

    // 대문자인 경우와 소문자인 경우를 나누어 진행
    if (ASCIICode >= 65 && ASCIICode <= 90) {
      ASCIICode += k;
      while (ASCIICode > 90) {
        ASCIICode -= 26;
      }
    } else if (ASCIICode >= 97 && ASCIICode <= 122) {
      ASCIICode += k;
      while (ASCIICode > 122) {
        ASCIICode -= 26;
      }
    }
    result += String.fromCharCode(ASCIICode);
  }
  return result;
}
