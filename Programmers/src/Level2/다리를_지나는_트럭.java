package Level2;

public class 다리를_지나는_트럭 {
    public static void main(String[] argv) {
        int[] t1 = {7, 4, 5, 6};
        int[] t2 = {10};
        int[] t3 = {10,10,10,10,10,10,10,10,10,10};

        System.out.println("ex1");
        System.out.println(solution(2, 10 ,t1));
        System.out.println();

        System.out.println("ex2");
        System.out.println(solution(100, 100 ,t2));
        System.out.println();

        System.out.println("ex3");
        System.out.println(solution(100, 100 ,t3));
        System.out.println();
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int[] truck_pos = new int[truck_weights.length];    // 트럭들의 위치. 0이면 대기중, -1이면 다리를 다 건넌 것.
        int i = 0;        // 다리위에 올라가 있는 트럭 중 마지막 트럭의 인덱스.
        int tmp;
        int cur_weight = truck_weights[i];      // 현재 다리 위에 있는 트럭의 무게의 합.
        truck_pos[i] = 1;       // 첫 번째 트럭이 다리 위에 올라가있다고 생각하고 시작. (시간이 1 경과한 상태.)

        while (truck_pos[truck_weights.length - 1] != -1) {
            answer++;       // 시간 경과.
            if ((tmp = move(i, bridge_length, truck_pos)) != -1)
                cur_weight -= truck_weights[tmp];       // 다리를 다 건넌 트럭의 무게를 빼줌.
            // 대기중인 트럭 중 가장 앞에 있는 트럭이 올라갈 수 있는지 확인. 올라갈 수 있다면 그 트럭을 한 칸 전진시킴.
            if (i != truck_weights.length - 1 && cur_weight + truck_weights[i + 1] <= weight) {
                cur_weight += truck_weights[++i];
                truck_pos[i]++;
            }
        }
        return answer;
    }

    // 다리위에 있는 트럭들을 한 칸씩 앞으로 전진시킴. 만약 다리를 다 건넌 트럭이 있다면 그 트럭의 인덱스를 리턴, 없다면 -1.
    private static int move(int idx, int max_len, int[] truck_pos) {
        int result = -1;
        for (int i = 0; i <= idx; i++) {
            // 다리를 끝까지 건넌 트럭은 그냥 넘어감.
            if (truck_pos[i] == -1) continue;
            truck_pos[i]++;
            // 다리를 끝까지 건넌 트럭, pos를 -1로 설정해준다.
            if (truck_pos[i] > max_len) {
                result = i;
                truck_pos[i] = -1;
            }
        }
        return result;
    }
}
