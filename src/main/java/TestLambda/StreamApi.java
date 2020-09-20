package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/19 17:10
 * @Description:
 */
public class StreamApi {
    //需求 : 学员的年龄大于25的
    List<Student> studentList = Arrays.asList(
            new Student("a43",18,188,38000),
            new Student("b77",20,178,28000),
            new Student("a16",20,181,25000),
            new Student("d89",22,175,30000),
            new Student("c33",25,183,32000)
        );

    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Student[] students = new Student[]{};
        Stream<Student> stream1 = Arrays.stream(students);

        Stream<String> stream2 = Stream.of("a","b","c");

        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);
    }

    @Test
    public void test2(){
        Stream<Student> studentStream=studentList.stream()
                .filter((x) ->x.getSalary() >20000)
                .filter((x) ->x.getAge()>20);

        studentStream.forEach(System.out::println);
    }

    @Test
    public void test3(){
        //map - 接收Lambda,将元素转换成其他形式提取信息
        //接收一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素

        Stream<String> stream =Stream.of("aaa","bbb","ccccc");
        stream.map((x) ->x.toUpperCase())
          //并行  后 换串行
//        stream.parallel().sequential()
                .forEach(System.out::println);
    }

}
