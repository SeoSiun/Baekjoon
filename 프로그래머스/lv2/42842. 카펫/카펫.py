def solution(brown, yellow):
    answer = []
    
    for i in range(yellow + 1):
        if i == 0:
            continue
                    
        if yellow % i != 0:
            continue

        
        if (yellow / i + 2) * (i + 2)  == brown + yellow:
            return [yellow / i + 2, (i + 2)]
    
    return answer