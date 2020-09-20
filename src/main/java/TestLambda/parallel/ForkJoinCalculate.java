package TestLambda.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/19 18:28
 * @Description:
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;

    private static final long THRESHOLD =10000;

    public ForkJoinCalculate(long start,long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end -start;
        if (length <= THRESHOLD){
            //当前任务数据区间小于10000
            long sum = 0;
            for (Long i = start; i <= end; i++) {
                sum+= i;
            }
            return sum;
        }else {
            //当前任务数据区间大于10000,运行任务拆分
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }

}
