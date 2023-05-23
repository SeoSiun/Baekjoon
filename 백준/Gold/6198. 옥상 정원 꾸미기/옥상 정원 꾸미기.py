from sys import stdin
import heapq


def main():
    n = int(stdin.readline())
    heights = [int(stdin.readline()) for i in range(0, n)]
    result = 0
    heap = []   # min heap, index와 함께 높이가 낮은 순서로 정렬

    for i in range(0, n):
        # 높이 min 값보다 크거나 같은 애가 나오면
        while heap and heap[0][0] <= heights[i]:
            idx = heapq.heappop(heap)[1]
            # min값인 애가 볼 수 있는 옥상 개수를 계산해서 더해줌
            result = result + i - idx - 1
        heapq.heappush(heap, [heights[i], i])

    # 끝까지 본인보다 높은 건물이 없었다면 전체 개수 - idx -1 로 볼 수 있는 옥상개수 계산
    while heap:
        idx = heapq.heappop(heap)[1]
        result = result + n - idx - 1

    print(result)


if __name__ == '__main__':
    main()