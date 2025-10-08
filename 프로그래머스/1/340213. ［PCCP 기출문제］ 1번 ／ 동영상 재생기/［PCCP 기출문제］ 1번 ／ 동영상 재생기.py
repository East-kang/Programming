def timeToInt(str):
    m = int(str[0:2])
    s = int(str[-2:])
    return m*60 + s

def timeToString(t):
    m = t//60
    s = t%60
    return "{mm:02d}:{ss:02d}".format(mm=m, ss=s)

def resultFormat(video_len, pos, op_start, op_end):
    if pos < 0:
        pos = 0
    if pos > video_len:
        pos = video_len
    if (pos >= op_start) and (pos <= op_end):
        pos = op_end
    return pos


def solution(video_len, pos, op_start, op_end, commands):
    video = timeToInt(video_len)
    start = timeToInt(op_start)
    end = timeToInt(op_end)
    position = resultFormat(video, timeToInt(pos), start, end)

    for command in commands:
        if command == "next":
            position += 10
        else:
            position -= 10
        position = resultFormat(video, position, start, end)
    
    return timeToString(position)