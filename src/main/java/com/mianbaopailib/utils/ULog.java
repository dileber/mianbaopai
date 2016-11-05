package com.mianbaopailib.utils;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

/**
 *
 * DEBUG Level: 指出细粒度信息事件对调试应用程序是非常有帮助的,就是输出debug的信息.
 * INFO level: 表明消息在粗粒度级别上突出强调应用程序的运行过程,就是输出提示信息.
 * WARN level: 表明会出现潜在错误的情形,就是显示警告信息.
 * ERROR level: 指出虽然发生错误事件,但仍然不影响系统的继续运行.就是显示错误信息.
 * FATAL level: 指出每个严重的错误事件将会导致应用程序的退出.
 * ALL level: 是最低等级的,用于打开所有日志记录.
 * OFF level: 是最高等级的,用于关闭所有日志记录.
 * log4j建议只使用五个级别,级别顺序(由低到高): DEBUG < INFO < WARN < ERROR < FATAL
 * Created by shidawei on 15/11/1.
 */
public class ULog {

    private static final Logger LOG = Logger.getLogger(ULog.class);

    public static void w(Object... args) {
        try {
            String msg = UString.concat(" ", args);
            LOG.warn(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void d(Object... args) {
        try {
            String msg = UString.concat(" ", args);
            LOG.debug(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void i(Object... args) {
        try {
            String msg = UString.concat(" ", args);
            LOG.info(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void f(Object... args) {
        try {
            String msg = UString.concat(" ", args);
            LOG.fatal(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void e(Object... args) {
        try {
            String msg = UString.concat(" ", args);
            LOG.error(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
