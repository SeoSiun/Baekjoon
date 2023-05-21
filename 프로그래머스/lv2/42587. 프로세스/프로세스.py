def solution(priorities, location):
    answer = 0
    
    while priorities:
        j = priorities[0]
        
        if j == max(priorities):
            answer += 1
            priorities.pop(0)

            if location == 0:
                break
        else:
            priorities.append(priorities.pop(0))
            
        location -= 1
        if location < 0:
            location = len(priorities) - 1


            
    return answer