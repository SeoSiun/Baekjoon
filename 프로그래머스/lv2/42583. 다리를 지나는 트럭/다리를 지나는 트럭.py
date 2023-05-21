def solution(bridge_length, weight, truck_weights):
    ing = []
    cur_weight = 0
    time = 0

    while truck_weights or ing:
        time += 1
        
        if len(ing) >= bridge_length:
            cur_weight -= ing.pop(0)

        if truck_weights and truck_weights[0] + cur_weight <= weight: 
            ing.append(truck_weights.pop(0))
            cur_weight += ing[-1]
        else:
            ing.append(0)
            
        if not truck_weights and max(ing) == 0:
            break
    
    return time