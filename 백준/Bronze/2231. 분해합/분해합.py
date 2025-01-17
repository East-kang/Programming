N=int(input())

for i in range(N//2, N):
    a=[]
    num=i
    digit,sum,result=0,0,0

    while num//(10**digit)>0:             # 임의의 정수 자릿수 구하기 (= 10의 digit-1 제곱)
        digit+=1

    for j in range(digit-1, -1, -1):     # 임의의 변수 자릿수에 해당하는 정수 값 저장
        a.append(num//(10**j))
        num=num%(10**j)
    a.append(num)

    for j in range(0, digit):
        sum+=a[digit-j-1]*(10**j)+a[digit-j-1]
        result+=a[digit-j-1]*(10**j)

    if sum==N:
        print(result)
        break
    elif i==N-1:
        print(0)