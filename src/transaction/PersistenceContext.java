/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import entities.Hotel;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ammar
 */
public class PersistenceContext {

    public static void main(String[] args) {
        ArrayList<String> hotels = new ArrayList<String>();
        hotels.add("hotel 10");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransactionPU");
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        for (String item : hotels) {

            Hotel hotel = new Hotel();
            hotel.setName(item);
            em.persist(hotel);
            hotel.setName("hotel11");
        }

        em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}