def solution(numbers):
    numbers = list(map(str, numbers))
        
    numbers.sort(key=lambda x: (x * 4)[:4], reverse=True)
    
    answer = ''.join(numbers)
    
    answer = answer.lstrip('0')
    if answer == '':
        answer = '0'
    
    return answer