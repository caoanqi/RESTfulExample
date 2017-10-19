package com.mkyong.dao.impl;

import com.mkyong.bean.UserEntity;
import com.mkyong.dao.UserDao;
import com.mkyong.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * 用户DAO实现
 *
 * @author waylau.com
 * 2014-3-23
 */
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity getUserById(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        UserEntity userEntity = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hsql = "select * from t_user where userId = "+ id;
            Query query = s.createSQLQuery(hsql).addEntity(UserEntity.class);
            userEntity = (UserEntity) query.uniqueResult();
            t.commit();
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return userEntity;
    }

    @Override
    public boolean deleteUserById(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        boolean flag = false;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(id);
            s.delete(userEntity);
            t.commit();
            flag = true;
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return flag;
    }

    @Override
    public boolean createUser(UserEntity userEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        boolean flag = false;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            s.save(userEntity);
            t.commit();
            flag = true;
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return flag;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        boolean flag = false;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            s.update(userEntity);
            t.commit();
            flag = true;
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return flag;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        List<UserEntity> uesrs = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hql = "select * from t_user";
            Query query = s.createSQLQuery(hql).addEntity(UserEntity.class);
            query.setCacheable(true); // 设置缓存
            uesrs = query.list();
            t.commit();
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return uesrs;
    }

}
