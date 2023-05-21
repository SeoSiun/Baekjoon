from heapq import heappush, heappop

def solution(scoville, K):
    answer = 0
    
    heap = []
    
    for s in scoville:
        heappush(heap, s)
    
    while len(heap) > 0:
        min1 = heappop(heap)
        if min1 >= K:
            return answer
        
        if len(heap) == 0:
            break
        
        min2 = heappop(heap)
        heappush(heap, min1 + min2 * 2)
        answer += 1
        
    return -1