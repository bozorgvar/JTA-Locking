package transaction;

import entities.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob2 implements Job {

    static int count = 1;

    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        System.out.println("Hello Quartz B!" + count++);
        count = (count > 3) ? 1 : count;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransactionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            sleepUnintrapted(1000);
            Users user = em.find(Users.class, 1, LockModeType.PESSIMISTIC_READ);
            // updating credit field
            user.setCredit((float) ((0.01 * user.getCredit()) + user.getCredit()));
            sleepUnintrapted(1000);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("rollback(B)");
            em.getTransaction().rollback();
        }
    }

    // sleep 1 seconds to more rollbacks
    public static void sleepUnintrapted(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
        }
    }
}
