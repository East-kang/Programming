n=int(input())

for i in range(n//2, n+1):
    num = sum(map(int, str(i)))+i
    if num==n:
        print(i)
        break
    elif i==n:
        print(0)