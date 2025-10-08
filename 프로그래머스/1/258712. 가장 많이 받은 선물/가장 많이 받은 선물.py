def solution(friends, gifts):
    answer = 0
    n = len(friends)

    # 사람 인덱스 구조
    friend_dict = dict()
    for i in range(n):
        friend_dict[friends[i]] = i

    table = [[0] * n for _ in range(n)]  # 선물 테이블
    gift_indices = [0] * n               # 선물 지수

    for gift in gifts:
        sender, reciever = gift.split()
        idx1, idx2 = friend_dict[sender], friend_dict[reciever]
        gift_indices[idx1] += 1          # 준 선물 수
        gift_indices[idx2] -= 1          # 받은 선물 수
        table[idx1][idx2] += 1           # 선물 테이블 구성

    get_gift = [0] * n                   # 다음달 받을 선물 리스트
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if table[i][j] > table[j][i]:
                get_gift[i] += 1
            elif table[i][j] == table[j][i]:
                if gift_indices[i] > gift_indices[j]:
                    get_gift[i] += 1
    answer = max(get_gift)
    return answer