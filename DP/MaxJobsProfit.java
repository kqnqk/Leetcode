import java.util.PriorityQueue;

public class MaxJobsProfit {
    class Job{
        int start;
        int end;
        int p;

        public Job(int s, int e, int p){
            this.start = s;
            this.end = e;
            this.p = p;
        }
    }
    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.println(new MaxJobsProfit().jobScheduling(startTime, endTime, profit));
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.start, b.start));

        for(int i = 0; i< startTime.length; i++){
            pq.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        for(int i = 0; i< startTime.length; i++){
            Job j = pq.poll();
            startTime[i] = j.start;
            endTime[i] = j.end;
            profit[i]= j.p;
        }



        return dfs(startTime,endTime,profit,0, new int [startTime.length]);
    }

    public int findNextJobId(int[] startTime, int[] endTime, int currI){
        int currEndTime = endTime[currI];
        int l = currI;
        int r = startTime.length -1;
        int nextJobId = -1;
        while(l<=r){
            int m = (l+r)/2;

            if(startTime[m] >=currEndTime){
                nextJobId = m;
                r = m-1;
            }
            else l = m+1;
        }
        // 0  1 2 3 4
        // [1,2,3,3]
        //      l r 
        //      m
        return nextJobId;
    }
    public int dfs(int[] startTime, int[] endTime, int[] profit, int i, int [] memo) {
        
        if(i >= startTime.length || i == -1) return 0;

       if(memo[i] != 0) return memo[i];
        int nextJobId = findNextJobId(startTime, endTime, i); //log(n)
        int takeJob =  profit[i] + dfs(startTime,endTime, profit,nextJobId ,memo);
        int notTaking = dfs(startTime,endTime,profit, i+1,memo);

        memo[i] =  Math.max(takeJob, notTaking);

        return memo[i];
        
    }
}