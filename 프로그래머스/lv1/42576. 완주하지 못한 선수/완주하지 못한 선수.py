def solution(participant, completion):
    sorted_participant = sorted(participant)
    sorted_completion = sorted(completion)
    
    for i in range(len(sorted_completion)):
        if sorted_participant[i] != sorted_completion[i]:
            return sorted_participant[i]
    
    return sorted_participant[-1]