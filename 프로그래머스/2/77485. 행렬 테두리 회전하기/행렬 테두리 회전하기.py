def solution(rows, columns, queries):
    answer = []
    n = 0
    table = [[0 for _ in range(columns)] for _ in range(rows)]
    
    for row in range(rows):
        for col in range(columns):
            n += 1
            table[row][col] = n

    for query in queries:
        tmp = []
        x1, y1, x2, y2 = query[0]-1, query[1]-1, query[2]-1, query[3]-1
        for y in range(y1, y2):
            tmp.append(table[x1][y])
        for x in range(x1, x2):
            tmp.append(table[x][y2])
        for y in range(y2, y1, -1):
            tmp.append(table[x2][y])
        for x in range(x2, x1, -1):
            tmp.append(table[x][y1])
        answer.append(min(tmp))
        
        i = 0
        for y in range(y1+1, y2+1):
            table[x1][y] = tmp[i]
            i+=1
        for x in range(x1+1, x2+1):
            table[x][y2] = tmp[i]
            i+=1
        for y in range(y2-1, y1-1, -1):
            table[x2][y] = tmp[i]
            i+=1
        for x in range(x2-1, x1-1, -1):
            table[x][y1] = tmp[i]
            i+=1
    return answer