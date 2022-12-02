function solution(s) {
    // 길이가 4 또는 6이 아니면 false 반환
    if (s.length !== 4 && s.length !== 6) return false;
      
    //숫자가 아닌 것이 하나라도 있으면 false 반환
    for (let i = 0; i < s.length; i++) {
      if (isNaN(s[i])) return false;
    }
    return true;
  }
  