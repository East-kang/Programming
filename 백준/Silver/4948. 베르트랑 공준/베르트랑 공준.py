import sys
import math

def is_prime(n):
    if n < 2:
        return False
    
    for i in range(2, int(n**0.5)+1):
        if n%i==0:
            return False
    return True

check = [0 for _ in range(123456*2)]

for i in range(0, 123456*2):
    if is_prime(i+1):
        check[i] = 1

input = sys.stdin.readline
ans = []

while True:
    n = int(input().strip())
    if n == 0:
        break
    else:
        ans.append(sum(check[n:2*n]))

for i in range(len(ans)):
    print(ans[i])