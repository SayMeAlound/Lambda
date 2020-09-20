package TestLambda.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/19 18:29
 * @Description:
 */
public class StreamApi2 {
    //需求  计算 0到 1亿的和   72   421


    @Test
    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (int i = 0; i <1000000000 ; i++) {
            sum+=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为"+ Duration.between(start,end).toMillis());
    }
    @Test
    //   505  2767
    public void test2(){
        Instant start = Instant.now();
        ForkJoinPool fjp = new ForkJoinPool();

        ForkJoinCalculate task = new ForkJoinCalculate(0, 1000000000L);

        Long sum =fjp.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费事件为"+ Duration.between(start,end).toMillis());
    }

    @Test
    //162
    public void test3(){
        Instant start = Instant.now();
        long res = LongStream.rangeClosed(0,100000000L).
                parallel().reduce(0,Long::sum);
        System.out.println(res);

        Instant end = Instant.now();
        System.out.println("耗费事件为"+ Duration.between(start,end).toMillis());
    }




}
