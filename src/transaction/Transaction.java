/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import entities.Hotel;
import entities.HotelDetails;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ammar
 */
public class Transaction {

    public static void main(String[] args) {
        ArrayList<String> hotels = new ArrayList<String>();
        hotels.add("hotel 10");
        hotels.add("hotel 11");
        hotels.add("hotel 12");
        hotels.add("hotel 13");
        hotels.add("hotel 14");
        hotels.add("hotel 15");
        hotels.add("hotel 16");
        hotels.add("hotel 17");
        hotels.add("hotel 18");
        hotels.add("hotel 19999999");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransactionPU");
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        for (String item : hotels) {

            Hotel hotel = new Hotel();
            HotelDetails hotelDetails = new HotelDetails();
            hotel.setName(item);
            hotelDetails.setHotelId(hotel);
            hotelDetails.setInternet("1");

            em.persist(hotel);
            em.persist(hotelDetails);
        }

        em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
