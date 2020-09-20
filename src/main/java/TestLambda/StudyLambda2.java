package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/16 21:05
 * @Description:
 */
public class StudyLambda2 {

    @Test
    public void test(){
        happy(1000,(m)-> System.out.println("zhaomo每次去洗脚,每次消费"+m+"元"));
    }

    private void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //需求1 :产生指定数量的整数,放入到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sp){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0 ;i<num; i++){
            list.add(sp.get());
        }
        return list;
    }

    @Test
    public void test2(){
        List<Integer> numList = getNumList(5,() ->(int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }

    //2.需求2 : 传入一个字符串,返回一个字符串
    public String strHander(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    @Test
    public void Test3(){
        String result = strHander("颜值担当",(x) ->x+ "ant老师");
        System.out.println(result);
    }




}
