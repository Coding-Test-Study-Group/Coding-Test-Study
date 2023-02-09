import sys

input = sys.stdin.readline

n, m = map(int, input().split())

# 듣도 못한 사람
input_1 = {str(input().rstrip()) for _ in range(n)}

# 보도 못한 사람
input_2 = {str(input().rstrip()) for _ in range(m)}

# 듣보잡
result = sorted(list(input_1 & input_2))

print(len(result), *result, sep="\n")
