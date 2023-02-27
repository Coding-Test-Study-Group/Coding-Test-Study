#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'twoArrays' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY A
#  3. INTEGER_ARRAY B
#

def twoArrays(k, A, B):
    # Write your code here
    aPrime = sorted(A) # 정렬합니다.
    bPrime = sorted(B, reverse = True) # 역순 정렬합니다.
    
    for i in range(len(aPrime)): # aPrime의 길이 만큼 순회합니다. (아마 iteratable 객체로 순회하는 것이 나을 것 같습니다)
        if aPrime[i] + bPrime[i] < k: # 조건을 확인합니다.
            return "NO"
    
    return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        k = int(first_multiple_input[1])

        A = list(map(int, input().rstrip().split()))

        B = list(map(int, input().rstrip().split()))

        result = twoArrays(k, A, B)

        fptr.write(result + '\n')

    fptr.close()
