"""
[해싱]
1. dict()와 배열 준비
2. 배열에는 숫자가 몇 번 등장했는지 저장
3. dict()에는 숫자의 인덱스 저장
4. 두 번 등장한 숫자의 인덱스 차와 숫자 비교
"""

T = int(input())
for _ in range(T):
    n = input()
    nums = [[] for _ in range(10)]
    counts = [0]*10

    for i in range(len(n)):
        nums[int(n[i])].append(i)
        counts[int(n[i])] += 1

    ans = False
    for i in range(10):
        if counts[i] == 0:
            continue
        if counts[i] == 2:
            if abs(nums[i][1] - nums[i][0]) != i+1:
                ans = False
                break
            else:
                ans = True
        else:
            ans = False
            break
    if ans:
        print("yes")
    else:
        print("no")