import sys
input = sys.stdin.readline

n, k = map(int, input().rsplit())

coins = []
for _ in range(n):
    coins.append(int(input()))

coins.sort(reverse=True)

answer = 0
for coin in coins:
    answer += k // coin
    k %= coin

print(answer)