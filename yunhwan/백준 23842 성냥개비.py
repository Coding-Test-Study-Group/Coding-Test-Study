N = int(input())

numbers = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]


def dfs(arr, idx, cnt):
    if idx == 6 or cnt < 0:
        if cnt == 4 and arr[0] * 10 + arr[1] + arr[2] * 10 + arr[3] == arr[4] * 10 + arr[5]:
            print(str(arr[0]) + str(arr[1]) + '+' + str(arr[2]) + str(arr[3]) + '=' + str(arr[4]) + str(arr[5]))
            exit()
        return

    for i in range(10):
        arr[idx] = i
        dfs(arr, idx + 1, cnt - numbers[i])
        arr[idx] = -1


dfs([-1] * 6, 0, N)

print('impossible')