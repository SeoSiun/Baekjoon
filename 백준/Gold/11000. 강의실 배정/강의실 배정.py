import heapq
from sys import stdin


def main():
    N = int(input())
    classes = []

    for i in range(0, N):
        c = stdin.readline().split(' ')
        classes.append([int(c[0]), int(c[1])])

    classes.sort(key=lambda x: x[0])

    rooms = []  # 각 강의실의 끝나는 시간을 저장
    heapq.heappush(rooms, classes[0][1])

    for i in range(1, N):
        if classes[i][0] >= rooms[0]:
            heapq.heappop(rooms)

        heapq.heappush(rooms, classes[i][1])

    print(len(rooms))


if __name__ == '__main__':
    main()