def createNum(value, index):
    result = 0
    for i in range(index):
        result += (value*(10**i))
    return result
    
T = int(input())
for _ in range(T):
    X = int(input())

    if X == 1:
        ans = 0
    else:
        ans = createNum(8, X//2) if X % 2 == 0 else createNum(8, X//2) + 4*(10**(X//2))
    print(ans)