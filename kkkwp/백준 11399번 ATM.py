n = int(input())
time = list(map(int, input().split()))
time.sort()
answer = 0
for i in range(n):
    answer += sum(time[0:i+1])
print(answer)