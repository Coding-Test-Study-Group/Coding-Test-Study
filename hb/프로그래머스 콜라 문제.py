# https://school.programmers.co.kr/learn/courses/30/lessons/132267
def solution(a, b, n):
    answer = 0
    give = 0
    get = 0
    while n >= a:
        # ㄱ. 마트에 줄 수 있는 최대 병수 a개 를 한쌍으로 취급해서 줄 수 있는 쌍이 아닌 실제 빈 병의 최대 개수 
        # (ex> a: 3, b: 20, n: 20 -> 20 / 3 = 6, 6 * a(3) == 18)
        give = n // a * a

        # ㄴ. 빈병 n개를 a 만큼 묶었을 때 묶은 쌍(n/a 몫) 1개 만큼 b를 돌려주기 때문에 n // a * b 
        get = n // a * b
        
        answer += get # 돌려 받은 새로운 콜라병 하나하나의 개수
        
        # 남은 빈병은 현재 빈병 - 제출한 빈병 + 새콜라를 받고 마셔서 생긴 병
        n = n - give + get
        
    return answer