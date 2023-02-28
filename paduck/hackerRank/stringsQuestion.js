/**
 * super round string
 * 중복을 제외한 값만 남기기
 * 스택 을 활용
 * 반복하며 값을 배열에 집어넣고
 * 하나씩 꺼내와 현재값과 비교
 */
function superReducedString(s) {
    // Write your code 
    let answer = [];
    let str = s.split("");
    str.forEach(el=>{
        if(answer[answer.length-1]===el)answer.pop();
        else{
            answer.push(el)
        }
    })
    return answer.length?answer.join(""):"Empty String"
}

/**
 * strong password
 * 숫자, 소문자, 대문자, 특수기호가 하나씩 들어간 최소 6자리 비밀번호로 변환하는 문제
 * 1) 최소 6자리를 만족해야하고, 하나의 조건을 만족했을 경우는 반드시 지켜지므로
 * 주어지는 비밀번호가 3개 보다 작거나 같을 경우 6-n개 반환
 * 2) 각 최소 조건을 정규식으로 변환해서, 일치하는 게 없을 경우 숫자 증가
 * **비밀번호 자리수와 추가로 필요한 값이 6을 넘을 경우 추가 필요 값을 리턴하고
 * **그렇지 않을 경우 6-n 리턴
 */
function minimumNumber(n, password) {
    // Return the minimum number of characters to make the password strong
    if(n <= 3){ return 6 - n; }

    let count = 0;
    if(password.match(/\d/) === null){ count++; }
    if(password.match(/[A-Z]/) === null){ count++; }
    if(password.match(/[a-z]/) === null){ count++; }
    if(password.match(/\W/) === null){ count++; }

    return (count + n >= 6) ? count : 6 - n;
}

/**
 * two characters
 * 조건1) 해당 문자열이 연속해서 문자가 나오는지 확인
 *   문자열을 한번씩 순회해 모든 문자가 특정 조건
 *   짝수일 경우에는 두 번째 자리, 홀수일 경우에는 첫 번째 자리가 반복되는지 확인
 * 조건2) Set을 활용해 중복을 제외한 조합 찾아내어
 * 전체 문자를 탐색해서, 나올 수 있는 경우의 수를 찾아내 제거
 */
function alternate(s) {
    // Write your code here
const alter = (str) => [...str].every((el, idx) => idx % 2 ? el === str[1] : el === str[0]);
    
    const comb = [...new Set(s)];
    let maxLength = 0;
    for (let i = 0; i < comb.length - 1; i++) {
        for (let j = i + 1; j < comb.length; j++) {
            const removed = s.replace(new RegExp(`[^${comb[i]}${comb[j]}]`, 'g'), '');
            if (alter(removed)) {
                maxLength = Math.max(maxLength, removed.length);
            }
        }
    }
    return maxLength;
}

/**
 * caesar cipher
 * 주어지는 숫자만큼 알파벳을 뒤로 미뤄서 암호문 만들기
 *   알파벳 외에는 건들면 안되므로 정규식으로 한 번 걸러주기
 *   charCodeAt을 활용해 아스키 값을 구하고, 주어지는 숫자를 알파벳 주기로 나누어 나머지만 확인
 *   Z와 z에 대해서 처음으로 돌아가게 26을 빼기
 */
function caesarCipher(s, k) {
    // Write your code here
    let answer ="";
    for(let i =0; i<s.length;i++){
        if(s[i].match(new RegExp(/[a-z]/))){
            let newStr = s.charCodeAt(i)+(k%26);
            if(newStr>122)newStr-=26;
            answer+=String.fromCharCode(newStr)
        }else{
            if(s[i].match(new RegExp(/[A-Z]/))){
                let newStr = s.charCodeAt(i)+(k%26);
                if(newStr>90)newStr-=26;
                answer+=String.fromCharCode(newStr)
            }else{
                answer+=s[i]
            }
        }
    }
    return answer;
}
/**
 * mars exploration
 * SOS 문자열을 계속해서 주어진 문자열과 비교해 다른 값 찾기
 * SOS 문자열 길이 넘어갈 경우 초기화하면서 전체 문자열 비교
 */
function marsExploration(s) {
    // Write your code here
    const check = "SOS";
    let checkIdx = 0;
    let cnt = 0;
    for(let i =0; i<s.length;i++){
        if(s[i]!==check[checkIdx])cnt++
        checkIdx++;
        if(checkIdx===3)checkIdx=0;
    }
    return cnt
}