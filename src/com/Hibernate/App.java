package com.Hibernate;

import com.Hibernate.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Faculty.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
//            insertInto(session);
//            ShowARecord(session);
//            update(session);
//            deleteRecords(session);
            session.beginTransaction();
            updateRecord(session);
            listRecords(session);
            session.getTransaction().commit();

        } catch (Exception e) {

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static void updateRecord(Session session) {
        session.createQuery("update Faculty set facultyName='Computer Engginering'").executeUpdate();
    }

    private static void listRecords(Session session) {
        List<Faculty> facultyList = session.createQuery("from Faculty").getResultList();
        for (Faculty temp : facultyList)
            System.out.println(temp);
    }

    private static void deleteRecords(Session session) {
        Faculty faculty = new Faculty();
        session.beginTransaction();
        faculty = session.get(Faculty.class, 123);
        session.delete(faculty);
        session.getTransaction().commit();
    }

    private static void update(Session session) {
        Faculty faculty = new Faculty();
        session.beginTransaction();
        faculty = session.get(Faculty.class, 123);
        faculty.setFacultyName("Civilization");
        session.getTransaction().commit();
    }

    private static void ShowARecord(Session session) {
        Faculty faculty = new Faculty();
        session.beginTransaction();
        faculty = session.get(Faculty.class, 123);
        session.getTransaction().commit();
        System.out.println(faculty);
    }

    private static void insertInto(Session session) {
        // Create Object of entity class type
        Faculty faculty = new Faculty(4322, "Medical");
        // Start Transaction
        session.beginTransaction();
        // Perform Operation
        session.save(faculty);
        // Commit the transaction
        session.getTransaction().commit();
        System.out.println("Row added");
    }
}
