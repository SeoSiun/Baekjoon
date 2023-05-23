from sys import stdin
import heapq


def main():
    n = int(stdin.readline())
    nums = list(map(int, stdin.readline().split(' ')))
    heap = []
    result = [-1] * n

    for i in range(n):
        # heap에서 현재 애보다 작은 애들을 다 꺼내서 작은 애의 NGE를 현재 애로 설정해줌.
        while heap and heap[0][0] < nums[i]:
            idx = heapq.heappop(heap)[1]
            result[idx] = nums[i]

        # 맨 왼쪽부터 보면서 하나씩 min heap에 넣음
        heapq.heappush(heap, (nums[i], i))

    print(*result)


if __name__ == "__main__":
    main()