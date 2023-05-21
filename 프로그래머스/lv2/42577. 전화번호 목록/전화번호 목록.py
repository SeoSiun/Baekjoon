def solution(phone_book):
    sorted_phone_book = sorted(phone_book)
    cur_num = sorted_phone_book[0]
    
    for i in range(len(sorted_phone_book) - 1):
        if sorted_phone_book[i + 1].startswith(cur_num):
            return False
        else:
            cur_num = sorted_phone_book[i + 1]
            
    return True