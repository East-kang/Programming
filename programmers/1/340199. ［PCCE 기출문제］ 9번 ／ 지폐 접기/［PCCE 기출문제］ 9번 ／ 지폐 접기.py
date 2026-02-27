def bill_NotIn_wallet(wallet, bill):
    if max(wallet)>=max(bill) and min(wallet)>=min(bill):
        return False
    else:
        return True

def solution(wallet, bill):
    answer = 0
    
    while bill_NotIn_wallet(wallet, bill):
        answer += 1
        if max(bill) == bill[0]:
            bill[0] = bill[0]//2
        else:
            bill[1] = bill[1]//2
            
        
    return answer