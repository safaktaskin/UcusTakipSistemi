package com.uniyaz.dao;

import com.uniyaz.domain.Ucus;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UcusDao {

    public Ucus saveUcus(Ucus ucus) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            ucus = (Ucus) session.merge(ucus);

            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return ucus;
    }

    public List<Ucus> findAllUcus() {

        List<Ucus> ucusList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {

            Query query = session.createQuery("Select ucus From Ucus ucus");
            ucusList = query.list();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        return ucusList;
    }

    public List<Ucus> getUcusBilgileri() {

        List<Ucus> ucusList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {

            Query query = session.createQuery("Select ucus From Ucus ucus ORDER BY ucus.id DESC ");
            query.setMaxResults(1);
            query.uniqueResult();
            ucusList = (List<Ucus>) query.list();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        return ucusList;
    }


//    public void guncelle(Ucus ucus) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        try (Session session = sessionFactory.openSession();) {
//            Query query = session.createQuery("update Ucus set gidisYeri = :gidisYeri" +
//                    " where id = :id");
//            int result = query.executeUpdate();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//
//    }


}
