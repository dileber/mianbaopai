package com.mianbaopailib.servlet;

import com.mianbaopailib.AppConstant;
import com.mianbaopailib.system.MyThreadPool;
import com.mianbaopailib.utils.ULog;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerAccessor;
import org.springframework.scheduling.quartz.SchedulerAccessorBean;

import javax.servlet.ServletContextEvent;
/**
 * Created by shidawei on 16/7/13.
 */
public class MyContextLoaderListener extends org.springframework.web.context.ContextLoaderListener{

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        ULog.i("web加载结束,关闭所有项目");
        myThreadPool.stop();
    }

    MyThreadPool myThreadPool;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        ULog.i("web加载开始,初始化");
        myThreadPool = AppContextConfig.context.getBean(MyThreadPool.class);
    }

    public static class AppContextConfig{
        public static final ApplicationContext context = getCurrentWebApplicationContext();
        public static final AppConstant contants;

        static {
            contants = context.getBean(AppConstant.class);
        }
    }


}
