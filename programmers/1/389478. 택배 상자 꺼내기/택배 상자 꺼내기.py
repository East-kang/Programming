def solution(n, w, num):
    answer = 0
    m1 = num % (w*2)
    m2 = (w*2-m1+1) % (w*2)
    for i in range(num, n+1):
        if i%(w*2) == m1 or i%(w*2) == m2:
            answer += 1
    return answer