package TestLambda;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/19 16:04
 * @Description:
 */

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.SocketHandler;

/**
 * 方法引用和对象调用
 * 若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用"
 * 可以理解为方法引用是Lambda表达式的另一种表现形式
 */
public class StudyLambda3 {
    //对象::实例方法名
    @Test
    public void test(){

//        Consumer<String> con =(x) ->System.out.println(x);
//        PrintStream printStream = System.out;

        //要注意的是接口的抽象方法的形参表,返回类型需要和调用的类方法形参表  返回类型保持一致
        Consumer<String> con = System.out::println;
        con.accept("123456");
    }

    //类 ::静态方法名
    @Test
    public void test2(){
        //要注意的是接口的抽象方法的形参表,返回类型需要和调用的类方法形参表  返回类型保持一致
        Comparator<Integer> com =(x,y) -> Integer.compare(x,y);

        Comparator<Integer> com2 = Integer::compare;
    }

    //类 :实例方法名
    @Test
    public void test3(){
        //需求: 比较两个字符串是否相等
        //要求: 第一个参数是实例方法的调用者,第二个参数是方法的传入参数
        BiPredicate<String,String> bp = (x,y) ->x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
    }

    //构造器引用

    @Test
    public void test4(){
        Supplier<Student> student = Student::new;

        Function<Integer,Student> student1= Student::new;
    }
}
