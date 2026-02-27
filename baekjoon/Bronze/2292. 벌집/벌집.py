N=int(input())
i=0
while True:
    i+=1
    if N<=3*i*(i-1)+1:
        break
print(i)