import java.util.Arrays;
import java.util.Comparator;

public class RecursiveIntervalScheduling {

    class JobComparator implements Comparator<Job> { 
        public int compare(Job job1, Job job2) { 
            if (job1.finish < job2.finish)
                return -1;
            else if (job1.finish == job2.finish)
                return 0;
            else
                return 1;
        } 
    } 


    public int jobScheduling(Job[] jobs) {
        sortByFinishTime(jobs);

        int n = jobs.length;
        int[] M = new int[n];

        int maxTotalWeight = findJobs(jobs, M, n-1);
        return maxTotalWeight;
    }

    private int findJobs(Job[] jobs, int[] M, int job) {
        if (job == 0)
            return jobs[job].weight;

        int included = jobs[job].weight;
        int prevCompatibleJob = findPrevCompatibleJob(jobs, job);
        if (prevCompatibleJob != -1)
            M[job] = Math.max(findJobs(jobs, M, job-1), included + findJobs(jobs, M, prevCompatibleJob));
        else
            M[job] = Math.max(findJobs(jobs, M, job-1), findJobs(jobs, M, included));
        return M[job];
    }
    
    private int findPrevCompatibleJob(Job[] jobs, int includedJob) {
        return BinarySearch.binarySearch(jobs, includedJob); 
    }

    private void sortByFinishTime(Job jobs[]) {
        Arrays.sort(jobs, new JobComparator());
    }

    
}
