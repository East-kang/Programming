"""
1. 큐 구조
2. 뒷 항목 중 크거나 같은 값 카운트
"""

from collections import deque

def solution(prices):
    answer = []
    prices = deque(prices)

    while prices:
        q = prices.popleft()
        count = 0
        
        for price in prices:
            count += 1
            if q > price:
                break
        answer.append(count)
    
    return answer