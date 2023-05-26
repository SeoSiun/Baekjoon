from sys import stdin


def main():
    n, k = list(map(int, stdin.readline().split()))
    nums = [*stdin.readline()][:-1]
    stack = []

    for num in nums:
        while stack and stack[-1] < num and k > 0:    # 내 앞에 나보다 작은애는 없애줌
            stack.pop(-1)
            k = k - 1

        stack.append(num)

    if k > 0:
        print(''.join(stack[:-k]))
    else:
        print(''.join(stack))


if __name__ == '__main__':
    main()
