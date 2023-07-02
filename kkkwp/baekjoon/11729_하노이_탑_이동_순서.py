import sys
input = sys.stdin.readline

def hanoi(a, b, n):
    # base condition
    # n = 1일 때 기둥 a에서 기둥 b로 옮김
    if n == 1:
        print(a, b)
        return
    
    # n-1개의 원판을 기둥 a에서 기둥 6 - a - b로 옮김
    # n번 원판을 기둥 a에서 기둥 b로 옮김
    # n-1개의 원판을 기둥 6 - a - b에서 기둥 b로 옮김
    hanoi(a, 6 - a - b, n - 1)
    print(a, b)
    hanoi(6 - a - b, b, n - 1)

k = int(input())
# 총 옮긴 횟수
print((1<<k) - 1)
hanoi(1, 3, k)
