package com.example.accessingdatajpa;

import java.util.List;


public class JPATest {

    BuddyInfo Mo;
    BuddyInfo Waleed;

    AddressBook addressBook;

    public static void main(String[] args) {

        JPATest test1 = new JPATest();
        test1.performJPA();

    }

    public void performJPA() {

        BuddyInfo buddy1 = new BuddyInfo("Mo", "123 Street", "1234");
        buddy1.setId(1L);

        BuddyInfo buddy2 = new BuddyInfo("Waleed", "321 Street", "4321");
        buddy2.setId(2L);

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(Mo);
        addressBook.addBuddy(Waleed);


        jakarta.persistence.EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-test");
        jakarta.persistence.EntityManager em = emf.createEntityManager();
        jakarta.persistence.EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(buddy1);
        em.persist(buddy2);
        tx.commit();

        tx.begin();
        em.merge(addressBook);
        tx.commit();


        jakarta.persistence.Query q = em.createQuery("Select b FROM BuddyInfo b");
        jakarta.persistence.Query a = em.createQuery("Select a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();
        List<AddressBook> results2 = a.getResultList();

        System.out.println("List of friends\n---------------");

        for (BuddyInfo buddyInfo : results) {
            System.out.println(buddyInfo);

        }

        System.out.println(("------------\nList of address books\n------------"));

        for (AddressBook ad : results2) {

            System.out.println(ad);

        }

        em.close();
        emf.close();

    }
}
