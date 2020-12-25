package com.tom.one.java.base.alibaba.guide;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * 1. 【强制】日期格式化时，传入 pattern 中表示年份统一使用小写的 y。
 * 说明：日期格式化时，yyyy 表示当天所在的年，而大写的 YYYY 代表是 week in which year（JDK7 之后
 * 引入的概念），意思是当天所在的周属于的年份，一周从周日开始，周六结束，只要本周跨年，返回的 YYYY
 * 就是下一年。
 * 正例：表示日期和时间的格式如下所示：
 * new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
 * 2. 【强制】在日期格式中分清楚大写的 M 和小写的 m，大写的 H 和小写的 h 分别指代的意义。
 * 说明：日期格式中的这两对字母表意如下：
 * 1） 表示月份是大写的 M；
 * 2） 表示分钟则是小写的 m；
 * 3） 24 小时制的是大写的 H；
 * 4） 12 小时制的则是小写的 h。
 * 3. 【强制】获取当前毫秒数：System.currentTimeMillis(); 而不是 new Date().getTime()。
 * 说明：如果想获取更加精确的纳秒级时间值，使用 System.nanoTime 的方式。在 JDK8 中，针对统计时间
 * 等场景，推荐使用 Instant 类。
 * 4. 【强制】不允许在程序任何地方中使用：1）java.sql.Date。 2）java.sql.Time。
 * 3）java.sql.Timestamp。
 * 说明：第 1 个不记录时间，getHours()抛出异常；第 2 个不记录日期，getYear()抛出异常；第 3 个在构造
 * 方法 super((time/1000)*1000)，在 Timestamp 属性 fastTime 和 nanos 分别存储秒和纳秒信息。
 * 反例： java.util.Date.after(Date)进行时间比较时，当入参是 java.sql.Timestamp 时，会触发 JDK
 * BUG(JDK9 已修复)，可能导致比较时的意外结果。
 * 5. 【强制】不要在程序中写死一年为 365 天，避免在公历闰年时出现日期转换错误或程序逻辑错误。
 * 正例：
 * // 获取今年的天数
 * int daysOfThisYear = LocalDate.now().lengthOfYear();
 * // 获取指定某年的天数
 * LocalDate.of(2011, 1, 1).lengthOfYear();
 * 反例：
 * // 第一种情况：在闰年 366 天时，出现数组越界异常
 * int[] dayArray = new int[365];
 * // 第二种情况：一年有效期的会员制，今年 1 月 26 日注册，硬编码 365 返回的却是 1 月 25 日
 * Calendar calendar = Calendar.getInstance();
 * calendar.set(2020, 1, 26);
 * calendar.add(Calendar.DATE, 365);
 * 6. 【推荐】避免公历闰年 2 月问题。闰年的 2 月份有 29 天，一年后的那一天不可能是 2 月 29 日。
 * 7. 【推荐】使用枚举值来指代月份。如果使用数字，注意 Date，Calendar 等日期相关类的月份 month 取值在 0-11 之间。
 * 说明：参考 JDK 原生注释，Month value is 0-based. e.g., 0 for January.
 * 正例： Calendar.JANUARY，Calendar.FEBRUARY，Calendar.MARCH 等来指代相应月份来进行传参或比较。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class DateTimeExample {
    public static void main(String[] args) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final long currentTimeMillis = System.currentTimeMillis();
        final long nanoTime = System.nanoTime();

        // 获取今年的天数
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println("daysOfThisYear:" + daysOfThisYear);
        // 获取指定某年的天数
        final int lengthOfYear = LocalDate.of(2011, 1, 1).lengthOfYear();
        System.out.println("lengthOfYear:" + lengthOfYear);

    }
}
