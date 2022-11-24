//https://school.programmers.co.kr/learn/courses/30/lessons/12933
function solution(n) 
{
  var numArr = []; // 배열을 담기위해 선언
  var numToStr = String(n); // 숫자를 문자로 캐스팅

  for (let i = 0; i < numToStr.length; i++)
  {
      numArr.push(numToStr[i]); // 정렬을 위해 배열화
  }

  let SortedNumArr = numArr.sort(function(a, b){return b - a}); // 오름차순으로 정렬

  let answerStr = ""; // 답을 위한 변수

  for (var idx in SortedNumArr)
  {
      answerStr += SortedNumArr[idx]; // 문자열 합치기
  }

  return answerStr * 1; // 숫자로 캐스팅
}

// (0.09ms, 33.7MB) 소요되었습니다.