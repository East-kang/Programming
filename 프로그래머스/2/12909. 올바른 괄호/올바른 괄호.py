"""
<풀이 방식>
- '(' -> 스택에 추가
- ')' -> pop
- 만약 전체 순회 후 '('가 남아있으면 False
- ')'일 때 '('가 스택에 없으면 False
- 나머지는 True
""" 
def solution(s):
    answer = True
    stack = []
    
    for i in s:
        if i == "(":
            stack.append("(")
        else:
            if not stack:
                return False
            else:
                stack.pop()
    if stack:
        return False
    return True