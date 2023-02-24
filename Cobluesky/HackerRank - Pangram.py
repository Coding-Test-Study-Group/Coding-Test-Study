#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'pangrams' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def pangrams(s):
    isIn = set() # 중복 제거를 위해 Set를 선언합니다.
    for i in s.lower(): # 전부 소문자로 변경합니다. (아마 없어도 될 것 같아요)
        if i != ' ': # 공백도 하나의 문자로 인식하므로, 제거를 위해 조건을 넣습니다.
            isIn.add(i); # set에 추가합니다.

    if len(isIn) == 26: # A ~ Z가 다 존재할경우, 길이가 26입니다.
        return "pangram"
    else:
        return "not pangram"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = pangrams(s)

    fptr.write(result + '\n')

    fptr.close()
