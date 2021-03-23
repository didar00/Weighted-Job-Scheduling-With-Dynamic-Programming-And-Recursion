import java.util.Arrays;
import java.util.Comparator;

public class IntervalScheduling {

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

    public int jobScheduling(Job jobs[]) { 
        sortByFinishTime(jobs);

        int n = jobs.length; 
        int M[] = new int[n]; 
        M[0] = jobs[0].weight; 
  

        for (int i=1; i<n; i++) { 
            
            int included = jobs[i].weight;
            int prevCompatibleJob = findPrevCompatibleJob(jobs, i);

            if (prevCompatibleJob!= -1)
                M[i] = Math.max(M[i-1], included+M[prevCompatibleJob]);
            else
                M[i] = Math.max(M[i-1], included);
        }

        return M[n-1];
    }

    private int findPrevCompatibleJob(Job[] jobs, int includedJob) {
        return BinarySearch.binarySearch(jobs, includedJob); 
    }

   
    private void sortByFinishTime(Job jobs[]) {
        Arrays.sort(jobs, new JobComparator());
    }

    
}
