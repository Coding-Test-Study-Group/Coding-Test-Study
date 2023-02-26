#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    # Write your code here
    hour, minute, second = s.split(":")
    if second[-2:] == "AM" and hour == "12":
        hour = "00"
    elif second[-2:] == "PM" and hour == "12":
        hour = "12"
    elif second[-2:] == "PM":
        hour = str(int(hour) + 12)
    return hour + ":" + minute + ":" + second[:2]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
