from bisect import bisect_left

n = int(input())
xList = list(map(int, input().split()))

targetList = sorted(list(set(xList))) # set을 통해 같은 수를 압축.
                                    # sorted() 메소드를 통해 xList 요소들을 복사해서 정렬

ans = []
for i in xList:
    a = bisect_left(targetList, i) #이분탐색을 통해 targetList의 i 인덱스를 좌측으로부터 번호를 읽어옴.
    ans.append(a) # 인덱스 번호를 정답 배열에 추가

print(*ans)