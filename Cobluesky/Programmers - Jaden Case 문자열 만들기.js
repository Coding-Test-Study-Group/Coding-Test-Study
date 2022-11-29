var answer = '';

answer = s.toLowerCase(); // 우선 전부 소문자로 만듭니다.

return answer.replace(/\b[a-z]/g, char => char.toUpperCase()) // 정규표현식을 사용해 처리합니다.
// \b => 문자의 경계선(공백)을 의미합니다. /g => 해당하는 전체를 의미합니다. [a-z] => a~z 중 해당하는 것을 의미합니다.