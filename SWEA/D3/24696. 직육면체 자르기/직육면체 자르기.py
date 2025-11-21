"""
[재귀]
규칙) 1. 길이 k일 때 k를 전부 1로 나눌 수 있는 경우의 수
        => 1+ (k//2 길이 일 때 경우) + (k-k//2 길이 일 때 경우)
     2. A 변을 나누는 경우: (A길이 나누는 경우)
        B 변을 이어서 나누는 경우: A * (B길이 나누는 경우)
        C 변을 이어서 나누는 경우: A * B * (C길이 나누는 경우)
        -> 결국 A등분 x B등분한 조각들의 변 C를 각각 나누기 때문
"""

def cut(n):
    if n == 1:
        return 0
    if n == 2:
        return 1
    return 1 + cut(n//2) + cut(n-n//2)

T = int(input())
for _ in range(T):
    A, B, C = map(int, input().split())
    if (cut(A) + A*cut(B) + A*B*cut(C)) % 2 == 0:
        print(2)
    else:
        print(1)