--https://school.programmers.co.kr/learn/courses/30/lessons/131536
SELECT USER_ID, PRODUCT_ID -- 찾을 컬럼
FROM ONLINE_SALE -- 테이블
GROUP BY USER_ID, PRODUCT_ID -- USER_ID, PRODUCT_ID를 그룹화
HAVING COUNT(*) >= 2 -- 재구매 항목을 찾아야함 (2회 이상 구매)
ORDER BY USER_ID, PRODUCT_ID DESC -- 내림차 순으로 정렬

