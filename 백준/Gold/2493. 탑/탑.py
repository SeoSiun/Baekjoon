import sys


def main():
    N = int(sys.stdin.readline())
    heights = list(map(int, sys.stdin.readline().split(' ')))
    result = [0] * N
    stack = []

    for i in range(0, N):
        while stack:
            if stack[-1][1] < heights[i]:
                stack.pop()
            else:
                result[i] = stack[-1][0] + 1
                break

        stack.append([i, heights[i]])

    print(*result)


if __name__ == '__main__':
    main()