import math

A,B,V=map(int, input().split())
date=math.ceil((V-A)/(A-B))+1
print(date)