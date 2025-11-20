T = int(input())
for C in range(1, T + 1):
    N, L = map(int, input().split())
    cal_arr = []
    for n in range(N):
        cal_arr.append(list(map(int, input().split())))
    ans = [0]

    def cal_sum(idx, s_sum, c_sum):
        if idx == N:
            ans[0] = max(ans[0], s_sum)
            return

        s, c = cal_arr[idx]
        if c_sum + c <= L:
            cal_sum(idx + 1, s_sum + s, c_sum + c)

        cal_sum(idx + 1, s_sum, c_sum)

    cal_sum(0, 0, 0)
    print(f"#{C} {ans[0]}")