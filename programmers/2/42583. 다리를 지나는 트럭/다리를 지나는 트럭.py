"""
- bridge_length 크기만큼 다리 배열 생성(0 초기화)
- 다리 위 총 무게 시간마다 갱신하기
- 다리 무게 + 트럭 무게 <= 제한 무게일 경우 계속 추가
- 마지막 트럭이 다리 위에 올라가는 순간 반복문 종료
- 마지막 트럭 이동 시간(다리 길이) 더하고 마무리
"""
from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0                             # 총 걸린 시간
    bridge = deque([0] * bridge_length)  # 다리 위 현황
    truck_weights = deque(truck_weights) # 트럭 모음
    w = 0                                # 현재 다리 총 무게

    while truck_weights:
        time += 1
        w -= bridge.popleft()            # 현재 다리 무게 = 다리 첫 칸 뺀 값

        if w + truck_weights[0] <= weight:
            w += truck_weights[0]
            bridge.append(truck_weights.popleft())
        else:
            bridge.append(0)

    time += bridge_length
    return time