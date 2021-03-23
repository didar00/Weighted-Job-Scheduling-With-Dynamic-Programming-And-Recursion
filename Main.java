
public class Main {
    public static void main(String[] args) {
        IntervalScheduling is = new IntervalScheduling();
        Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20), new Job(6, 19, 100), new Job(2, 100, 200)};
        
        RecursiveIntervalScheduling ris = new RecursiveIntervalScheduling();
        int x = ris.jobScheduling(jobs);
        System.out.println(x);
    }
}
