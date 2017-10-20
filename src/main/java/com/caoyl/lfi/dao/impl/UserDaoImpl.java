package com.caoyl.lfi.dao.impl;

import com.caoyl.lfi.bean.UserBean;
import com.caoyl.lfi.dao.UserDao;
import com.caoyl.lfi.util.HibernateUtil;
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
    public UserBean getUserById(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        UserBean userBean = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hsql = "select * from t_user where userId = " + id;
            Query query = s.createSQLQuery(hsql).addEntity(UserBean.class);
            userBean = (UserBean) query.uniqueResult();
            t.commit();
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return userBean;
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
            UserBean userBean = new UserBean();
            userBean.setUserId(id);
            s.delete(userBean);
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
    public boolean createUser(UserBean userBean) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        boolean flag = false;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            s.save(userBean);
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
    public boolean updateUser(UserBean userBean) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        boolean flag = false;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            s.update(userBean);
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
    public List<UserBean> getAllUsers() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        List<UserBean> uesrs = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hql = "select * from t_user";
            Query query = s.createSQLQuery(hql).addEntity(UserBean.class);
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


    public UserBean getUserWithUserName(String userName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        UserBean userBean = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hsql = "select * from t_user where userName = " + userName;
            Query query = s.createSQLQuery(hsql).addEntity(UserBean.class);
            userBean = (UserBean) query.uniqueResult();
            t.commit();
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return userBean;
    }

    public UserBean getUserWithUserNameAndPwd(String userName, String password) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = null;
        Transaction t = null;
        UserBean userBean = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            String hsql = "select * from t_user where userName ='" + userName + "' and " + "password ='" + password + "'";
            Query query = s.createSQLQuery(hsql).addEntity(UserBean.class);
            userBean = (UserBean) query.uniqueResult();
            t.commit();
        } catch (Exception err) {
            t.rollback();
            err.printStackTrace();
        } finally {
            s.close();
        }
        return userBean;
    }

}
