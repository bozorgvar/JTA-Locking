package transaction;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class schedule {

    public static void main(String[] args) {

        // jobs
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("dummyJobName", "group1").build();
        JobDetail job2 = JobBuilder.newJob(HelloJob2.class)
                .withIdentity("dummyJobName2", "group2").build();
        
        // triggers
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ?")) //every second
                .build();
        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName2", "group2")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ?")) //every second
                .build();

        //schedule it
        Scheduler scheduler;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(job2, trigger2);
        } catch (SchedulerException ex) {
            Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
