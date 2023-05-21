def solution(genres, plays):
    answer = []
    g_plays = {}
    m_nums = {}
    
    for i in range(len(genres)):
        g_plays[genres[i]] = g_plays.get(genres[i], 0) + plays[i]
        
        tmp = m_nums.get(genres[i], {})
        tmp[i] = plays[i]
        m_nums[genres[i]] = tmp
    
    g_plays = dict(sorted(g_plays.items(), key=lambda item: -item[1]))

    for g, p in g_plays.items():
        tmp = dict(sorted(m_nums[g].items(), key=lambda item: -item[1]))
        answer += list(tmp.keys())[:2]
    
    return answer