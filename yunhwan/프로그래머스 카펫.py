def solution(brown, yellow):
    answer = []

		#총 격자의 수
    total = brown + yellow
    row = 1
    col = total//row
    
	
    for i in range(1,brown):
        # row * col =total 이용
				row = i
        col = total//row
				#조건을 나열하여 만족한다면 break
				#노란색 타일은 row-2 * col-2
				#row >= col
				#갈색 타일은 2*row + 2*col -4(중복타일 제거)
        if (row-2) * (col-2) == yellow and row>=col and 2*row +2*col -4 ==brown:
            break
                
    answer = [row,col]
    
    return answer