package cn.geoary.config;

import cn.geoary.service.CornService;
import cn.geoary.util.JavaRunBat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @program: java-run-bat
 * @description: 重新配置
 * @author: Zhangc
 * @create: 2019-06-02 21:02
 **/
@Configuration
@EnableScheduling
public class CornConfig implements SchedulingConfigurer {
    @Autowired
    @SuppressWarnings("all")
    private CornService cornService;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                //() -> System.out.println("执行定时任务2: " + LocalDateTime.now().toLocalTime()),
                // 调用脚本
                () -> JavaRunBat.runBat(),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cornService.getCorn();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}

