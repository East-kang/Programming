def solution(today, terms, privacies):
    answer = []
    te_dict = dict()
    result = []
    Y, M, D = map(int, today.split('.'))
    current = Y*28*12 + M*28 + D
    
    for term in terms:
        type, due = map(str, term.split())
        te_dict[type] = int(due)

    for i in range(len(privacies)):
        date, type = map(str, privacies[i].split())
        Y, M, D = map(int, date.split('.'))
        start = Y*28*12 + M*28 + D
        
        if start + 28*te_dict[type] <= current:
            print(i+1)
            answer.append(i+1)

    return answer