package com.yixihan.random.day0831;

/**
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * <p>
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * <p>
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * <p>
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * <p>
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * <p>
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-08-31-9:43
 */
public class AngleClock {

    public double angleClock(int hour, int minutes) {
        double minuteAngle = (minutes * 6) % 360;
        double hourAngle = (hour * 30) % 360 + minutes * 0.5;

        return hourAngle > minuteAngle ?
                Math.min (hourAngle - minuteAngle, 360 - (hourAngle - minuteAngle)) :
                Math.min (minuteAngle - hourAngle, 360 - (minuteAngle - hourAngle));
    }
}
