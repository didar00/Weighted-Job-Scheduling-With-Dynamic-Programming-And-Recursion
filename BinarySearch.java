public class BinarySearch {
    public static int binarySearch(Job jobs[], int index) { 
        int lo = 0, hi = index - 1; 
  
        while (lo <= hi) 
        { 
            int mid = (lo + hi) / 2; 
            if (jobs[mid].finish <= jobs[index].start) 
            { 
                if (jobs[mid + 1].finish <= jobs[index].start) 
                    lo = mid + 1; 
                else
                    return mid; 
            } 
            else
                hi = mid - 1; 
        } 
        return -1; 
    }
}
