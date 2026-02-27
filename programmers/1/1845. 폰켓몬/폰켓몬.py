def solution(nums):
    answer = len(set(nums))
    if len(nums) // 2 < answer:
        answer = len(nums) // 2
    return answer