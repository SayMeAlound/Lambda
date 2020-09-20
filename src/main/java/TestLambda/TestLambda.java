package TestLambda;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/16 20:14
 * @Description:
 */
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {

                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>((x,y) ->Integer.compare(9,10));
    }

    //需求  学员  年龄大于25
    List<Student>  studentList = Arrays.asList(
            new Student("a34",18,188,350000),
            new Student("b44",20,176,25000),
            new Student("c82",23,172,12500),
            new Student("d66",25,178,650000)
    );

    public List<Student> filterStudent1(List<Student> list){
        List<Student> result =new ArrayList<Student>();
        for (Student student:list) {
            if (student.getAge()>23){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> filterStudent2(List<Student> list){
        List<Student> result =new ArrayList<Student>();
        for (Student student:list) {
            if (student.getSalary()>25000){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> filterStudent3(List<Student> list,Mypredicate<Student> predicate){
        List<Student> result =new ArrayList<Student>();
        for (Student student:list) {
            if (predicate.test(student)){
                result.add(student);
            }
        }
        return result;
    }

    @Test
    public void test2(){
        List<Student> result =filterStudent3(studentList,(x)-> x.getSalary()>25000);
        result.forEach(System.out::println);
    }

    @Test
    public void test3(){
        studentList.stream()
                .filter((x) ->x.getSalary()>25000)
                .filter((x) ->x.getAge()>18)
                .limit(0)
                .forEach(System.out::println);


        //提取所有人的姓名
        studentList.stream()
                .map(Student::getName)
                .forEach(System.out::println);


    }
}
