"""
0. progresses가 전부 pop 될 때까지 수행
1. progresses[0]이 100 이상이 되는 날짜 계산하기
2. 해당 일수만큼 뒤에 값에 대입. 이때 100을 넘긴 항목은 넘어가기
3. 100 이상인 값들 popleft
4. 갯수 세서 answer에 저장
"""

from collections import deque
import math

def solution(progresses, speeds):
    answer = []                    # 정답
    progresses = deque(progresses) # 작업 목록
    speeds = deque(speeds)         # 진행 속도 목록
    
    while progresses:              # 작업 목록 전부 pop 되기 전까지 반복
        n = len(progresses)        # 배포 전 작업 갯수
        count = 0                  # 한 번에 배포할 작업 갯수
        term = math.ceil((100 - progresses[0]) / speeds[0])  # 먼저 배포 해야할 항목 배포까지 걸리는 시간
        
        for i in range(n):         # 작업 시간 갱신
            progresses[i] += (term*speeds[i])

        while progresses:
            if progresses[0] >= 100:
                count += 1
                progresses.popleft()
                speeds.popleft()
            else:
                break
        answer.append(count)
    return answer