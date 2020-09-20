package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/16 21:05
 * @Description:
 */
public class StudyLambda1 {
    /**
     * 语法1 无参数 无返回值
     */
    @Test
    public void test1(){
        int num = 123; //1.7
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("bat.ke.qq.com"+num);
            }
        };

        //箭头操作符将lambda表达式拆分为两部分
        //左侧:lambda表达式的参数列表
        //右侧: lambda表达式中所需执行的功能,即Lambda体
        //函数式接口

        Runnable runnable1 = () -> System.out.println("bat.ke.qq.com"+num);

        runnable.run();
    }

    /**
     * 语法2 一个参数 无返回值
     */
    @Test
    public void test2(){
        Consumer<String> com =(x) ->System.out.println(x);
        com.accept("只为培养bat 程序员");

    }

    /**
     * 语法3 只有一个参数  省略括号
     *x
     */
    @Test
    public void test3(){
        Consumer<String> com = x->System.out.println(x);
        com.accept("只为培养bat 程序员");

    }

    /**
     * 语法4 : 有两个以上参数,有返回值,并且Lambda体中有多条语句
     */

    @Test
    public void test4(){
        Comparator<Integer> com =(x,y) -> {
            System.out.println("111");
            return Integer.compare(x,y);

        };
    }

    /**
     * 语法5 : Lambda体中只有一条语句 return和大括号都可以省略不写
     */
    @Test
    public void test5(){
        Comparator<Integer> com =(x,y) ->Integer.compare(x,y);
        List<String> list = new ArrayList<>();
        //类型判断
        String[] strs = {"111","111","1111"};
    }

    /**
     * 语法6 : 参数指定类型
     */
    @Test
    public void test6(){
        Comparator<Integer> com =(x,y) ->Integer.compare(x,y);
        //上下文推断--
//        Comparator<Integer> com = (Integer x, Integer y) ->Integer.compare(x,y);

    }

}
