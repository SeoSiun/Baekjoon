from sys import stdin


def main():
    walls = []
    pos = [7, 0]   # 가장 왼쪽 아래

    for i in range(8):
        board = stdin.readline()
        idx = board.find('#')
        while idx != -1:
            walls.append([i, idx])
            idx = board.find('#', idx + 1)

    print(move(walls, pos))


def move(walls, pos):
    if len(walls) == 0:  # 더 이상 장애물이 존재하지 않으면 성공
        return 1

    if pos == [0, 7]:    # 가장 오른쪽 윗 칸에 도착하면 성공
        return 1

    if pos in walls:    # 벽이랑 만나면 실패
        return 0

    result = 0
    next_walls = get_next_walls(walls, pos)
    for i in range(3):
        for j in range(3):
            new_pos = [pos[0] + i - 1, pos[1] - j + 1]
            if new_pos in walls:   # 벽 있는 위치로는 이동 불가
                continue
            if new_pos[0] < 0 or new_pos[0] > 7 or new_pos[1] < 0 or new_pos[1] > 7:  # 범위 벗어나는지 체크
                continue

            result = move(next_walls, new_pos)
            if result == 1:
                return 1

    return result


def get_next_walls(walls, pos):
    new_walls = []
    for wall in walls:
        if wall[0] < 7 and wall[0] <= pos[0]:
            new_walls.append([wall[0] + 1, wall[1]])

    return new_walls


if __name__ == "__main__":
    main()