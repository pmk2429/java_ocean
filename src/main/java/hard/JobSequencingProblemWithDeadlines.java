package hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Job Sequencing Problem with Deadlines
 * Given a list of tasks with deadlines and total profit earned on completing a task, find the maximum profit earned
 * by executing the tasks within the specified deadlines.
 * Assume that each task takes one unit of time to complete, and a task can’t execute beyond its deadline. Also, only
 * a single task will be executed at a time.
 * <p>
 * For example, consider the following set of tasks with a deadline and the profit associated with it.
 * If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, we can achieve a maximum profit of 109.
 * Note that task 2 and task 10 are left out.
 * <p>
 * Tasks	Deadlines	   Profit
 * -----------------------------
 * 1            9           15
 * 2            2           2
 * 3            5           18
 * 4            7           1
 * 5            4           25
 * 6            2           20
 * 7            5           8
 * 8            7           10
 * 9            4           12
 * 10           3           5
 */
public class JobSequencingProblemWithDeadlines {

    private static class Job {
        public int taskId, deadline, profit;

        public Job(int taskId, int deadline, int profit) {
            this.taskId = taskId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    private static void scheduleJobs(List<Job> jobs, int T) {
        // stores the maximum profit that can be earned by scheduling jobs
        int profit = 0;

        // array to store used and unused slots info
        int[] slot = new int[T];
        Arrays.fill(slot, -1);

        // arrange the jobs in decreasing order of their profits
        jobs.sort((a, b) -> b.profit - a.profit);

        // consider each job in decreasing order of their profits
        for (Job job : jobs) {
            // search for the next free slot and map the task to that slot
            for (int i = job.deadline - 1; i >= 0; i--) {
                // if time is less than the Max deadline and slot is not yet filled:
                if (i < T && slot[i] == -1) {
                    slot[i] = job.taskId;
                    profit += job.profit;
                    break;
                }
            }
        }

        System.out.println("The scheduled jobs are " +
            Arrays.stream(slot).filter(val -> val != -1).boxed().collect(Collectors.toList())
        );

        System.out.println("The total profit earned is " + profit);
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 9, 15),
            new Job(2, 2, 2),
            new Job(3, 5, 18),
            new Job(4, 7, 1),
            new Job(5, 4, 25),
            new Job(6, 2, 20),
            new Job(7, 5, 8),
            new Job(8, 7, 10),
            new Job(9, 4, 12),
            new Job(10, 3, 5)
        );

        // stores the maximum deadline that can be associated with a job
        final int T = 15;

        // schedule jobs and calculate the maximum profit
        scheduleJobs(jobs, T);
    }
}
