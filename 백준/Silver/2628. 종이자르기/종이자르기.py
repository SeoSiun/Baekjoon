from sys import stdin


def main():
    w, h = list(map(int, stdin.readline().split(' ')))
    n = int(stdin.readline())
    lists = [[0, h], [0, w]]

    for i in range(0, n):
        kind, num = list(map(int, stdin.readline().split(' ')))
        lists[kind].append(num)

    h_list = sorted(lists[0])
    w_list = sorted(lists[1])

    max_h = 0
    max_w = 0

    for i in range(len(h_list) - 1):
        max_h = max(max_h, h_list[i + 1] - h_list[i])

    for i in range(len(w_list) - 1):
        max_w = max(max_w, w_list[i + 1] - w_list[i])

    print(max_h * max_w)


if __name__ == "__main__":
    main()