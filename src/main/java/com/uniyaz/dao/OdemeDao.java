package com.uniyaz.dao;

import com.uniyaz.domain.Odeme;
import com.uniyaz.domain.Ucus;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OdemeDao extends BaseDao {


    public Odeme saveOdeme(Odeme odeme) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            odeme = (Odeme) session.merge(odeme);

            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return odeme;
    }

    public List<Odeme> findAllOdeme() {

        List<Odeme> odemeList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {

            Query query = session.createQuery("Select odeme From Odeme odeme");
            odemeList = query.list();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        return odemeList;
    }

}
