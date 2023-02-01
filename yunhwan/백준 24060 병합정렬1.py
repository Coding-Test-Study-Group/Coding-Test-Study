import sys

input = sys.stdin.readline

n, k = map(int, input().split())
a = list(map(int, input().split()))
tmp = [0] * n
i, j, t, q = 0, 0, 0, 0
cnt = 0


#cnt번째 교환시 해당 수 출력
def find(cnt, ans):
    if cnt == k:
        print(ans)
        return (-1)


def merge_sort(a, p, r):
    if p < r:
        #q를 중간값으로 설정
        q = (p + r) // 2
        #왼쪽 정렬
        merge_sort(a, p, q)
        #오른쪽 정렬
        merge_sort(a, q + 1, r)
        #합치기
        merge(a, p, q, r)


def merge(a, p, q, r):
    i = p
    j = q + 1
    t = 0
    global cnt

    while i <= q and j <= r:
        if a[i] <= a[j]:
            tmp[t] = a[i]
            t += 1
            i += 1
        else:
            tmp[t] = a[j]
            t += 1
            j += 1
        cnt += 1
        find(cnt, tmp[t - 1])

    #왼쪽 배열 부분이 남은경우
    while i <= q:
        tmp[t] = a[i]
        t += 1
        i += 1
        cnt += 1
        find(cnt, tmp[t - 1])

    #오른쪽 배열 부분이 남은 경우
    while j <= r:
        tmp[t] = a[j]
        t += 1
        j += 1
        cnt += 1
        find(cnt, tmp[t - 1])

    i = p
    t = 0
    #결과 저장
    while i <= r:
        a[i] = tmp[t]
        i += 1
        t += 1


merge_sort(a, 0, n - 1)
if cnt < k:
    print(-1)