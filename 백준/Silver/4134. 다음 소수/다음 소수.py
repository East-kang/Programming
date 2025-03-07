import sys
import math
input = sys.stdin.readline

def is_prime(n):
    if n < 2:
        return False
    else:
        for i in range(2, int(n**0.5) + 1):
            if n % i == 0:
                return False
        return True

T = int(input().strip())
result = []

for _ in range(T):
    n = int(input().strip())
    
    while True:
        if is_prime(n):
            break
        else:
            n += 1
            
    result.append(n)

for i in result:
    print(i)