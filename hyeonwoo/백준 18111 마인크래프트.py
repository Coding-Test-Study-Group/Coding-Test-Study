import sys

input = sys.stdin.readline

n, m, b = map(int, input().split())
heights = [list(map(int, input().split())) for _ in range(n)]

# 입력 받은 높이를 중복 제거하여 집합 자료형에 담는다.
targets = set([height for inner_heights in heights for height in inner_heights])

""" 예외 처리 1
입력 받은 땅의 높이가 모두 같을 경우
땅 고르기 작업을 할 필요가 없다.
"""
# 중복 제거한 높이가 2개 이상이면 작업 시작
if len(targets) > 1:
    results = {}

    # 땅을 고르는 작업
    for target in targets:
        time = 0  # 소요 시간

        # 먼저 target 높이에 맞춰 블럭 제거하기
        for inner_height in heights:
            for height in inner_height:
                if height > target:
                    # 제거할 블럭 개수
                    block = height - target

                    # 인벤토리에 블럭 추가
                    b += block

                    # 소요 시간 계산
                    time += block * 2

                    # target 높이만큼 높이 변경
                    height = target

        # target 높이에 맞춰 블럭 쌓기
        for inner_height in heights:
            for height in inner_height:
                if height < target:
                    # 쌓을 블럭 개수
                    block = abs(height - target)

                    # 인벤토리에 쌓을 블럭 만큼, 블럭이 없다면 작업 중단
                    if b - block < 0:
                        break

                    # 인벤토리에 쌓을 블럭 만큼, 블럭이 남아있으면 작업 시작
                    if b - block >= 0:
                        # 인벤토리에서 블럭 제거
                        b -= block

                        # 소요 시간 계산
                        time += block * 1

        results[time] = target

    # 딕셔너리에 담은 결과에서 소요 시간들만 배열에 담는다
    results_time = results.keys()

    # 예외 처리 2: 소요 시간이 0초인 것은 제외
    if 0 in results_time:
        del results[0]

    # 작업에 걸린 최소 시간
    min_time = min(results_time)

    # 작업에 걸린 최소 시간일 때의 땅의 높이
    height = results[min_time]

# 중복 제거한 높이가 하나만 있다면 땅이 모두 고르기 때문에
# 작업할 필요가 없다.
if len(targets) <= 1:
    print(0, targets[0])
