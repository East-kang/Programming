def solution(id_list, report, k):
    n = len(id_list)
    answer = []
    reports = list(set(report))   # 중복 신고 제거

    # 인원별 신고 당한 횟수
    ids = dict()
    user = dict()
    for id in id_list:
        ids[id] = 0
        user[id] = 0
        
    for r in reports:
        a, b = map(str, r.split())
        ids[b] += 1

    for i in range(len(reports)):
        a, b = map(str, reports[i].split())
        if ids[b] >= k:
            user[a] += 1

    for id in id_list:
        answer.append(user[id])
    return answer