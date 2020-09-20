package TestLambda;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Auther: zhaomo
 * @Date: 2020/09/20 20:18
 * @Description:
 */
public class TimeApi {
    public static void main(String[] args) {

        //本地日期,不包括时分秒
        LocalDate nowDate = LocalDate.now();
        //本地日期,包括时分秒
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("当前时间:"+nowDate);
        System.out.println("当前时间:"+nowDateTime);

        //获取当前的时间，包括毫秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前年:"+ldt.getYear());
        System.out.println("当前年份天数:"+ldt.getDayOfYear());
        System.out.println("当前月:"+ldt.getMonthValue());
        System.out.println("当前时:"+ldt.getHour());
        System.out.println("当前分:"+ldt.getMinute());
        System.out.println("当前时间:"+ldt.toString());

        //格式化输出
        System.out.println("格式化时间: "+ ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println("后5天时间:"+ldt.plusDays(5));
        System.out.println("前5天时间并格式化:"+ldt.minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("前一个月的时间:"+ldt.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM")));
        System.out.println("后一个月的时间:"+ldt.plusMonths(1));
        System.out.println("指定2099年的当前时间:"+ldt.withYear(2099));

        //通过指定年月日来创建
        LocalDate ld3=LocalDate.of(2019, Month.JULY, 01);
        LocalDate ld4=LocalDate.of(2020, 9,20);
        System.out.println(ld3);
        System.out.println(ld4);

        //具体相差的年月日
        Period p=Period.between(ld3, ld4);
        System.out.println("相差年: "+p.getYears()+" 相差月 :"+p.getMonths() +" 相差天:"+p.getDays());

        //相差总数的时间ChronoUnit 日期周期单位的标准集合。
        LocalDate startDate = LocalDate.of(2019, 07, 01);
        LocalDate endDate = LocalDate.of(2020,9,20);
        System.out.println("相差月份:"+ ChronoUnit.MONTHS.between(startDate, endDate));
        System.out.println("两月之间的相差的天数   : " + ChronoUnit.DAYS.between(startDate, endDate));

        //精度时间相差   Duration 这个类以秒和纳秒为单位建模时间的数量或数量。
        Instant inst1 = Instant.now();
        System.out.println("当前时间戳 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("增加之后的时间 : " + inst2);
        System.out.println("相差毫秒 : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("相毫秒 : " + Duration.between(inst1, inst2).getSeconds());

        //时间大小比较
        LocalDateTime ldt4 = LocalDateTime.now();
        LocalDateTime ldt5 = ldt4.plusDays(10);
        System.out.println("当前时间是否大于:"+ldt4.isAfter(ldt5));
        System.out.println("当前时间是否小于"+ldt4.isBefore(ldt5));

        //通过Clock时钟类获取计算Clock时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。
        Clock clock = Clock.systemUTC();
        System.out.println("当前时间戳 : " + clock.millis());
        Clock clock2 = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println("亚洲上海此时的时间戳:"+clock2.millis());
        Clock clock3 = Clock.system(ZoneId.of("America/New_York"));
        System.out.println("美国纽约此时的时间戳:"+clock3.millis());
        //通过ZonedDateTime类和ZoneId
        ZoneId zoneId= ZoneId.of("America/New_York");
        ZonedDateTime dateTime=ZonedDateTime.now(zoneId);
        System.out.println("美国纽约此时的时间 : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println("美国纽约此时的时间 和时区: " + dateTime);

    }
}
