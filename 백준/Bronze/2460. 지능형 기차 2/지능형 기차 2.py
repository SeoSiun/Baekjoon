from sys import stdin


def main():
    cur_num = 0
    max_num = 0

    for i in range(10):
        num_out, num_in = list(map(int, stdin.readline().split()))

        cur_num = cur_num - num_out + num_in
        max_num = max(max_num, cur_num)

    print(max_num)


if __name__ == '__main__':
    main()