def solution(survey, choices):
    answer = ''
    n = len(survey)
    survey1 = ['R', 'C', 'J', 'A']
    survey2 = ['T', 'F', 'M', 'N']
    table = dict()
    scores = [0] * 4

    for s in survey1:
        table[s] = 0

    for s in survey2:
        table[s] = 0
        
    for i in range(n):
        choice = choices[i]-4
        if choice < 0:
            table[survey[i][0:1]] -= choice
        else:
            table[survey[i][1:2]] += choice

    for i in range(4):
        scores[i] = table[survey1[i]] - table[survey2[i]]
        if scores[i] >= 0:
            answer += survey1[i]
        else:
            answer += survey2[i]
    
    return answer