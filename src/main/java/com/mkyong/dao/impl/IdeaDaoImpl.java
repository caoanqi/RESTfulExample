package com.mkyong.dao.impl;

import com.mkyong.bean.IdeaBean;
import com.mkyong.dao.IdeaDao;
import com.mkyong.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class IdeaDaoImpl implements IdeaDao {

    @Override
    public IdeaBean getIdeaById(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        IdeaBean ideaBean = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String sql = "select * from t_idea where id=" + id;
            Query query = session.createSQLQuery(sql).addEntity(IdeaBean.class);
            ideaBean = (IdeaBean) query.uniqueResult();
            transaction.commit();

        } catch (Exception err) {
            transaction.rollback();
            err.printStackTrace();
        } finally {
            session.close();
        }
        return ideaBean;
    }

    @Override
    public boolean deleteIdeaById(String id) {
        return false;
    }

    @Override
    public boolean createIdea(IdeaBean ideaBean) {
        return false;
    }

    @Override
    public boolean updateIdea(IdeaBean ideaBean) {
        return false;
    }


    @Override
    public List<IdeaBean> getAllIdeas() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        List<IdeaBean> ideaBeans = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String sql = "select * from t_idea";
            Query query = session.createSQLQuery(sql).addEntity(IdeaBean.class);
            query.setCacheable(true);
            ideaBeans =  query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return ideaBeans;
    }
}
