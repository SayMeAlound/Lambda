package TestLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

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

        //转换大写
        List<String> list3 = Arrays.asList("zhangSan", "liSi", "wangWu");
        System.out.println("转换之前的数据:" + list3);
        List<String> list4 = list3.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("转换之后的数据:" + list4);

        List<Integer> list5 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
        List<Integer> list6 = list5.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("平方的数据:" + list6);

        //转换类型
        List<String> list7 = Arrays.asList("1", "2", "3");
        System.out.println("转换之前的数据:" + list7);
        List<Integer> list8 = list7.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("转换之后的数据:" + list8);

        //通过与 findAny 得到 if/else 的值
        List<String> list9 = Arrays.asList("张三", "李四", "王五", "xuwujing");
        String result3 = list9.stream().filter(str -> "李四".equals(str)).findAny().orElse("找不到!");
        String result4 = list9.stream().filter(str -> "李二".equals(str)).findAny().orElse("找不到!");

        System.out.println("stream 过滤之后 2:" + result3);
        System.out.println("stream 过滤之后 3:" + result4);


        List<String> strings = Arrays.asList("a", "", "c", "", "e","", " ");
        // 获取空字符串的数量
        long count =  strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的个数:"+count);

        //得到最大最小值
        List<String> list13 = Arrays.asList("zhangsan","lisi","wangwu","xuwujing");
        int maxLines = list13.stream().mapToInt(String::length).max().getAsInt();
        int minLines = list13.stream().mapToInt(String::length).min().getAsInt();
        System.out.println("最长字符的长度:" + maxLines+",最短字符的长度:"+minLines);

        String lines = "good good study day day up";
        List<String> list14 = new ArrayList<String>();
        list14.add(lines);
        List<String> words = list14.stream().flatMap(line -> java.util.stream.Stream.of(line.split(" "))).filter(word -> word.length() > 0)
                .map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        System.out.println("去重复之后:" + words);
        //去重复之后:[day, good, study, up]
    }

}
