def solution(n, w, num):
    answer = 0
    rows = n//w + 1
    cols = w
    index = -1
    box = []
    
    for row in range(rows):
        tmp = []
        for col in range(1, cols+1):
            if row * w + col > n:
                tmp.append(0)
            else:
                tmp.append(row * w + col)
            
        if row % 2 != 0:
            tmp.reverse()
        box.append(tmp)
        
    for row in range(rows):
        for col in range(cols):
            if box[row][col] == num:
                index = col
            if (box[row][col] >= num) and (col == index):
                answer+=1
    
    return answer