import sys
import math

input = sys.stdin.readline
A, B = map(int, input().strip().split())

print(A * B // math.gcd(A, B))