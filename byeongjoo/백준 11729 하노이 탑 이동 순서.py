import sys
sys.setrecursionlimit(10000) # 파이썬 재귀 리밋 뚫기

def hanoi(n, a, b): # recursive
    if n == 1 : # base condition - 제일 꼭대기 원판
        print(a, b)
        return

    hanoi(n-1, a, 6-a-b) # n-1개의 원판을 시작 막대기에서 6-a-b 막대기로 옮기기
    print(a, b) # 옮긴 원판 찍기
    hanoi(n-1, 6-a-b, b) # 6-a-b 막대기에서 끝 막대기로 옮기기

n = int(input())
print(2**n -1)
"""
원판 k개를 옮기기 위해 A번 이동이 필요.

원판 k+1개를 옮길 때 k 개의 원판을 빈곳을 옮길 때 A번, k+1번 원판을 옮길 때 1번,
k개의 원판을 다시 빈곳에서 목적지로 옮길 때 A 번 필요하므로 2A+1 번의 이동이 필요.

초항이 1이 되기에, 일반항은 2^k - 1 .
"""
hanoi(n, 1, 3)