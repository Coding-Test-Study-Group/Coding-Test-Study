import sys

input = sys.stdin.readline

arithmetic_quiz = list(map(str, input().split()))

a = int(arithmetic_quiz[0])
b = int(arithmetic_quiz[2])
c = int(arithmetic_quiz[4])

if a + b == c:
    print("YES")

if a + b != c:
    print("NO")
