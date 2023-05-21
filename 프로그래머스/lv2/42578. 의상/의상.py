def solution(clothes):
    dict = {}
    answer = 1
    
    for c in clothes:
        dict[c[1]] = dict.get(c[1], 0) + 1
    
    for t, n in dict.items():
        answer *= n + 1
        
    return answer - 1