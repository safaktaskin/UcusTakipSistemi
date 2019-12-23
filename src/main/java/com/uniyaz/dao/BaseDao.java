package com.uniyaz.dao;

import com.uniyaz.utils.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDao implements Serializable {

    public void findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }


}
