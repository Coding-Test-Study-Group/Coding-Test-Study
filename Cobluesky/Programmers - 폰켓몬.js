//https://school.programmers.co.kr/learn/courses/30/lessons/1845

//다소 엉망인 풀이입니다.

function solution(nums) {
  var answer = 0;

  nums = nums.sort(); // 필요 없습니다.

  var selectedPonketmon = new Set(); // 중복제거를 위해 Set를 만듭니다.

  for (const idx in nums) {
    selectedPonketmon.add(nums[idx]); // 순회하며 Set에 추가합니다.
  }

  if (selectedPonketmon.size > nums.length / 2) { 
    return nums.length / 2; // set size보다 n/2 가 크다면 set size를 적용합니다. (최대치가 n / 2)
  } else {
    return selectedPonketmon.size; // 그 외에는 set size를 적용합니다.
  }
}

// 풀이가 좀 개판입니다.
// sort는 필요없고, set를 굳이 for문 안에서 순회시킬 필요 없이 구조 분해 할당자를 이용하면 됩니다.
// 아쉬움이 좀 남네요...
