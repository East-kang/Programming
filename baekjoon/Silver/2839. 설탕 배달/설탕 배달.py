N = int(input())
count5 = N // 5
i = 0

if N // 5 == 0:
    if N % 3 == 0:
        print(N // 3)
    else:
        print(-1)
else:
    while True:
        count3 = ((N % 5) + 5 * i) // 3
        if ((N % 5) + 5 * i) % 3 == 0:
            print(count5 + count3)
            break
        else:
            i += 1
            count5 -= 1

        if count5 < 0:
            print(-1)
            break