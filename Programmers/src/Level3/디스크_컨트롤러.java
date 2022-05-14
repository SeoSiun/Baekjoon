package Level3;

import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public static void main(String[] argv) {
        int[][] j1 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] j2 = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
        int[][] j3 = {{0, 10}, {2, 12}, {9, 19}, {15, 17}};
        int[][] j4 = {{0, 1}};
        int[][] j5 = {{1000, 1000}};
        int[][] j6 = {{0, 1}, {0, 1}, {0, 1}};
        int[][] j7 = {{0, 10}, {4, 10}, {15, 2}, {5, 11}};
        int[][] j8 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int[][] j9 = {{10, 10}, {30, 10}, {50, 2}, {51, 2}};
        int[][] j10 = {{0, 3}, {1, 9}, {2, 6}, {30, 3}};
        int[][] j11 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
        int[][] j12 = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};

        System.out.println("ex1: 9 / " +solution(j1));
        System.out.println("ex2: 14 / " + solution(j2));
        System.out.println("ex3: 25 / " +solution(j3));
        System.out.println("ex4: 1 / " + solution(j4));
        System.out.println("ex5: 1000 / " +solution(j5));
        System.out.println("ex6: 2 / " + solution(j6));
        System.out.println("ex7: 15 / " + solution(j7));
        System.out.println("ex8: 74 / " + solution(j8));
        System.out.println("ex9: 6 / " + solution(j9));
        System.out.println("ex10: 7 / " + solution(j10));
        System.out.println("ex11: 74 / " + solution(j11));
        System.out.println("ex12: 13 / " + solution(j12));

    }

    private static class Job implements Comparable<Job> {
        private int start_time;
        private int require_time;

        public Job(int[] job) {
            this.start_time = job[0];
            this.require_time = job[1];
        }
        @Override
        public int compareTo(Job o) {
            // 소요시간이 작은 작업이 앞에오게 함. 소요시간이 같다면 요청시점이 빠른 작업이 앞에 오도록 함.
            if (this.require_time > o.require_time) return 1;
            else if (this.require_time == o.require_time) {
                return Integer.compare(this.start_time, o.start_time);
            }
            else return -1;
        }
    }

    // 작업 요청부터 종료까지 걸린 시간의 평균을 줄이기 위해서는 새로운 작업을 시작할 때마다 소요시간이 가장 짧은 작업을 선택해야함.
    // SJF(Shortest Job First) scheduling
    public static int solution(int[][] jobs) {
        int answer = 0, time = 0;
        Job cur_job, min;
        PriorityQueue<Job> pq = new PriorityQueue<>();

        min = new Job(jobs[0]);
        pq.add(min);
        for (int i = 1; i < jobs.length; i++) {
            cur_job = new Job(jobs[i]);
            if (min.start_time > jobs[i][0] ||
                    min.start_time == jobs[i][0] && min.require_time > jobs[i][1]) {
                min = cur_job;
            }
            pq.add(cur_job);
        }

        // 소요시간이 가장 작은 작업을 가장 먼저 선택함.
        cur_job = min;
        while (!pq.isEmpty()) {
            // 만약 현재 선택된 작업의 요청시점이 현재 시간보다 늦다면,
            if (cur_job.start_time > time) {
                min = ((Job)pq.stream().sorted().toArray()[0]);
                // 남아있는 작업을 소요시간이 짧은 순서로 보면서, 요청시점이 현재 시점보다 빠른 작업이 있다면 그 작업을 선택함.
                for(int i = 0; i < pq.size(); i++) {
                    if (((Job)pq.stream().sorted().toArray()[i]).start_time <= time) {
                        cur_job = ((Job)pq.stream().sorted().toArray()[i]);
                        break;
                    }
                    else if (min.start_time > ((Job)pq.stream().sorted().toArray()[i]).start_time)
                        min = (Job)pq.stream().sorted().toArray()[i];
                    // 만약 요청시점이 현재시점보다 빠른 작업이 없다면 시간을 가장 빠른 요청시간으로 초기화해주고, 가장 빠른 작업을 선택함.
                    if (i == pq.size() - 1) {
                        time = min.start_time;
                        cur_job = min;
                    }
                }
            }
            // 선택된 작업의 요청부터 종료까지 걸린 시간을 answer에 더해주고, 소요시간을 time에 더해줌.
            answer += (time - cur_job.start_time) + cur_job.require_time;
            time += cur_job.require_time;
            // 끝낸 작업을 제거해줌.
            pq.remove(cur_job);
            // 남아있는 작업 중 소요시간이 가장 짧은 작업을 선택함.
            cur_job = pq.peek();
        }
        // 평균을 구하기 위해 모든 작업의 요총부터 종료까지 걸린 시간의 합을 작업 개수로 나눠줌.
        return answer / jobs.length;
    }
}
