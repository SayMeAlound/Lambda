package TestLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zhaomo
 * @Date: 2020/09/20 19:38
 * @Description:
 */
public class Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "李四", "王五", "赵默");
        System.out.println("过滤之前:" + list);
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if (!"李四".equals(str)) {
                result.add(str);
            }
        }
        System.out.println("过滤之后:" + result);
        List<String> result2 = list.stream().filter(str -> !"李四".equals(str)).collect(Collectors.toList());
        System.out.println("stream 过滤之后:" + result2);


    }

}
