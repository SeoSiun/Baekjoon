import java.util.PriorityQueue;

class Solution {
    private class Job implements Comparable<Job> {
        private int start_time;
        private int require_time;

        public Job(int[] job) {
            this.start_time = job[0];
            this.require_time = job[1];
        }
        public int getStart_time() {
            return start_time;
        }
        public int getRequire_time() {
            return require_time;
        }
        @Override
        public String toString() {
            return "{" + start_time + ", " + require_time + '}';
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
    public int solution(int[][] jobs) {
        int answer = 0, time = 0;
        Job cur_job, min;
        PriorityQueue<Job> pq = new PriorityQueue<>();
//
//        for(int[] j : jobs) pq.add(new Job(j));
//        while(!pq.isEmpty()) System.out.print(pq.remove() + " ");
//        System.out.println();

        min = new Job(jobs[0]);
        pq.add(min);
        for (int i = 1; i < jobs.length; i++) {
            cur_job = new Job(jobs[i]);
            if (min.getStart_time() > jobs[i][0] ||
                    min.getStart_time() == jobs[i][0] && min.getRequire_time() > jobs[i][1]) {
                min = cur_job;
            }
            pq.add(cur_job);
        }

        // 소요시간이 가장 작은 작업을 가장 먼저 선택
        cur_job = min;
     //   System.out.println(min);
        while (!pq.isEmpty()) {
            // 만약 현재 선택된 작업의 요청시점이 현재 시간보다 늦다면,
            if (cur_job.getStart_time() > time) {
                min = ((Job)pq.stream().sorted().toArray()[0]);
                // 남아있는 작업을 소요시간이 짧은 순서로 보면서, 요청시점이 현재 시점보다 빠른 작업이 있다면 그 작업을 선택함.
                for(int i = 0; i < pq.size(); i++) {
             //       System.out.println((Job)pq.stream().sorted().toArray()[i]);
                    if (((Job)pq.stream().sorted().toArray()[i]).getStart_time() <= time) {
                        cur_job = ((Job)pq.stream().sorted().toArray()[i]);
                        break;
                    }
                    else if (min.getStart_time() > ((Job)pq.stream().sorted().toArray()[i]).getStart_time())
                        min = (Job)pq.stream().sorted().toArray()[i];
                    // 만약 요청시점이 현재시점보다 빠른 작업이 없다면 시간을 가장 빠른 요청시간으로 초기화해주고, 가장 빠른 작업을 선택함.
                    if (i == pq.size() - 1) {
                        time = min.getStart_time();
                        cur_job = min;
                    }
                }
            }
            // 선택된 작업의 요청부터 종료까지 걸린 시간을 answer에 더해주고, 소요시간을 time에 더해줌.
            answer += (time - cur_job.getStart_time()) + cur_job.getRequire_time();
            time += cur_job.getRequire_time();
            // 끝낸 작업을 제거해줌.
            pq.remove(cur_job);
            // 남아있는 작업 중 소요시간이 가장 짧은 작업을 선택함.
            cur_job = pq.peek();
        }
        // 평균을 구하기 위해 모든 작업의 요총부터 종료까지 걸린 시간의 합을 작업 개수로 나눠줌.
        return answer / jobs.length;
    }
}