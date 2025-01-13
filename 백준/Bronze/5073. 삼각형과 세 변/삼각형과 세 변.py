while True:
    a=list(map(int,input().split()))
    a.sort()
    if a.count(0)==3:
        break
    elif a[2]<a[0]+a[1]:
        if a.count(a[0])==3:
            print("Equilateral")
        elif a[0]==a[1] or a[1]==a[2] or a[0]==a[2]:
            print("Isosceles")
        else:
            print("Scalene")
    else:
        print("Invalid")