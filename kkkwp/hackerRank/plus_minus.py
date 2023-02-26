#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'plusMinus' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#

def plusMinus(arr):
    # Write your code here
    plus = 0
    minus = 0
    zero = 0
    for it in arr:
        if it > 0:
            plus += 1
        elif it < 0:
            minus += 1
        else:
            zero += 1
    length = len(arr)
    print(plus / length)
    print(minus / length)
    print(zero / length)

if __name__ == '__main__':
    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
