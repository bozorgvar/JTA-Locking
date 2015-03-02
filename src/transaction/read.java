/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import entities.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ammar
 */
public class read {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransactionPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Hotel> query = em.createQuery("select a from Hotel a", Hotel.class);
//        query.setParameter("num", 25);
        List<Hotel> list = query.getResultList();
        for (Hotel a : list) {
            System.out.println(a.getName() + " --- ");
        }

            	//Quartz 1.6.3
        //JobDetail job = new JobDetail();
        //job.setName("dummyJobName");
        //job.setJobClass(HelloJob.class);    	
//        JobDetail job = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("dummyJobName", "group1").build();

	//Quartz 1.6.3
        //CronTrigger trigger = new CronTrigger();
        //trigger.setName("dummyTriggerName");
        //trigger.setCronExpression("0/5 * * * * ?");
//        Trigger trigger = TriggerBuilder
//                .newTrigger()
//                .withIdentity("dummyTriggerName", "group1")
//                .withSchedule(
//                        CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
//                .build();

        //schedule it
//        Scheduler scheduler;
//        try {
//            scheduler = new StdSchedulerFactory().getScheduler();
//            scheduler.start();
//            scheduler.scheduleJob(job, trigger);
//        } catch (SchedulerException ex) {
//            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
