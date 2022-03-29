
def solution(info, query):
    answer = []
    sinfo=[]

    # info들을 점수의 오름차순으로 정렬해두자 -> 정렬하는 함수가 있나? -> sort
    # binay search로 점수가 조건 이상인 애들을 찾아서 걔네만 나머지 조건 검사하자.
    for i in info:
        s = i.split()
        sinfo.append((s[0],s[1],s[2],s[3],int(s[4])))
    sinfo = sorted(sinfo, key=lambda sinfo: sinfo[4])
    
    for q in query:
        squery = q.split()
        answer.append(cntInfo(squery, sinfo))

    return answer

def cntInfo(squery, sinfo):
    score = int(squery[7])
    
    high = len(sinfo)
    low = 0
    
    while low<high:
        mid = int((low+high)/2)
        if sinfo[mid][4]<score: low = mid+1
        elif sinfo[mid][4]>score: high=mid
        else:
            low = mid
            break

    while sinfo[low][4] == sinfo[low-1][4] and low!=0: low = low-1
        
    cnt =0
    for i in range(low,len(sinfo)):
        if sinfo[i][0] != squery[0] and squery[0]!="-": continue
        if sinfo[i][1] != squery[2] and squery[2]!="-": continue
        if sinfo[i][2] != squery[4] and squery[4]!="-": continue
        if sinfo[i][3] != squery[6] and squery[6]!="-": continue
        if sinfo[i][4] >= score: cnt += 1

    return cnt