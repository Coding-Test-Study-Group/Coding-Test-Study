import sys

input = sys.stdin.readline

matrix = [list(map(int, input().split())) for _ in range(9)]

results = {}
for row, row_matrix in enumerate(matrix):
    max_matrix = max(row_matrix)

    x = row + 1
    y = row_matrix.index(max_matrix) + 1

    results[max_matrix] = (x, y)

max_matrix = max(results.keys())

print(max_matrix)
print(*results.get(max_matrix))
