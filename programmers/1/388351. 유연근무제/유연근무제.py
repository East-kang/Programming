def solution(schedules, timelogs, startday):
    answer = len(schedules)
    
    for i in range(len(schedules)):
        for j in range(7):
            day = (startday - 1 + j) % 7  # 0=월, 1=화, ..., 5=토, 6=일
            if day in (5, 6):             # 토, 일은 건너뛰기
                continue
            # 평일만 비교
            if timeCover(timelogs[i][j]) > timeCover(schedules[i]) + 10:
                answer -= 1
                break
    return answer
    
def timeCover(t):
    h = t // 100
    m = t % 100
    return h*60 + m