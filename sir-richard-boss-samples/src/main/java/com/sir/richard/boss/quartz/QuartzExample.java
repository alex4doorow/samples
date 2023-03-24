package com.sir.richard.boss.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

@Slf4j
public class QuartzExample {

    public static void main(String args[]) {


        try {
            SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = stdSchedulerFactory.getScheduler();

            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("myJob", "group1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
                    .build();

            JobDetail jobA = JobBuilder.newJob(JobA.class)
                    .withIdentity("jobA", "group2")
                    .build();

            JobDetail jobB = JobBuilder.newJob(JobB.class)
                    .withIdentity("jobB", "group2")
                    .build();

            Trigger triggerA = TriggerBuilder.newTrigger()
                    .withIdentity("triggerA", "group2")
                    .startNow()
                    .withPriority(15)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
                    .build();

            Trigger triggerB = TriggerBuilder.newTrigger()
                    .withIdentity("triggerB", "group2")
                    .startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
                    .build();

            Trigger triggerD = TriggerBuilder.newTrigger()
                    .withIdentity("cronTriggerD", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();

            Trigger triggerF = TriggerBuilder.newTrigger()
                    .withIdentity("cronTriggerD", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 07 19 * * ?"))
                    .build();


            //scheduler.scheduleJob(job, trigger);
            //scheduler.scheduleJob(jobA, triggerA);
            //scheduler.scheduleJob(jobB, triggerB);
            scheduler.scheduleJob(job, triggerD);

            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}