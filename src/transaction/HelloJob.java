/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import entities.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Ammar
 */
public class HelloJob implements Job {

    static int count = 0;
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello Quartz A!" + count++);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransactionPU");
        EntityManager em = emf.createEntityManager();

        try {
        em.getTransaction().begin();
        Users user = em.find(Users.class, 1,LockModeType.PESSIMISTIC_READ);
        user.setCredit(user.getCredit()+10);
        
        em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("rollback(A)");
            em.getTransaction().rollback();
        }
    }
}
