n=int(input())

for i in range(int(n*0.6), n+1):
    num = sum(map(int, str(i)))+i
    if num==n:
        print(i)
        break
    elif i==n:
        print(0)