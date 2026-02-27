N,k=map(int, input().split())
a=[]
q=1
for i in range(N):
    if N%q==0:
        a.append(q)
    q+=1

if len(a)<k:
    print(0)
else:
    print(a[k-1])